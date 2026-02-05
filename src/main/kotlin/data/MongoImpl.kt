package data

import com.mongodb.client.model.Filters
import com.mongodb.client.model.FindOneAndUpdateOptions
import com.mongodb.client.model.Indexes
import com.mongodb.client.model.ReturnDocument
import com.mongodb.client.model.Updates
import com.mongodb.client.result.UpdateResult
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import com.toxicbakery.bcrypt.Bcrypt
import core.data.AdminData
import data.collection.PlayerAccount
import data.collection.PlayerData
import data.collection.ServerData
import io.ktor.util.date.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import user.model.ServerMetadata
import user.model.UserProfile
import utils.logging.Logger
import kotlin.io.encoding.Base64

/**
 * Store the count of registered player, to generate `playerId`.
 */
@Serializable
data class PlayerCounter(
    val _id: String = "playercounter",
    val seq: Long = 100L
)

/**
 * Implementation of [Database] using MongoDB.
 */
class MongoImpl(db: MongoDatabase, private val adminEnabled: Boolean) : Database {
    private val accountCollection = db.getCollection<PlayerAccount>("player_account")
    private val dataCollection = db.getCollection<PlayerData>("player_data")
    private val serverCollection = db.getCollection<ServerData>("server_data")
    private val counter = db.getCollection<PlayerCounter>("playercounter")

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> getCollection(name: String): MongoCollection<T> {
        return when (name) {
            "player_account" -> accountCollection
            "player_data" -> dataCollection
            "server_data" -> serverCollection
            else -> {
                throw IllegalArgumentException("Invalid collection name: $name")
            }
        } as MongoCollection<T>
    }

    init {
        Logger.info { "Initializing MongoDB..." }
        CoroutineScope(Dispatchers.IO).launch {
            setupCollections()
        }
    }

    private suspend fun setupCollections() {
        try {
            val count = accountCollection.estimatedDocumentCount()
            Logger.info { "MongoDB: User collection ready, contains $count users." }

            if (adminEnabled) {
                val adminDoc = accountCollection.find(Filters.eq("userId", AdminData.USER_ID)).firstOrNull()
                if (adminDoc == null) {
                    val start = getTimeMillis()
                    val doc = PlayerAccount.admin()
                    val obj = PlayerData.admin()

                    accountCollection.insertOne(doc)
                    dataCollection.insertOne(obj)

                    Logger.info { "MongoDB: Admin enabled, account inserted in ${getTimeMillis() - start}ms" }
                } else {
                    Logger.info { "MongoDB: Admin enabled, account already exists." }
                }
            }
            setupIndexes()
        } catch (e: Exception) {
            Logger.error { "MongoDB: Failed during setupCollections: $e" }
        }
    }

    suspend fun setupIndexes() {
        accountCollection.createIndex(Indexes.text("profile.displayName"))
    }

    override suspend fun loadPlayerAccount(userId: Long): PlayerAccount? {
        return accountCollection.find(Filters.eq("userId", userId)).firstOrNull()
    }

    override suspend fun loadPlayerData(userId: Long): PlayerData? {
        return dataCollection.find(Filters.eq("userId", userId)).firstOrNull()
    }

    override suspend fun loadServerData(): ServerData {
        return serverCollection.find().firstOrNull() ?: throw NoSuchElementException("No global ServerData found")
    }

    override suspend fun createPlayer(username: String, password: String): Long {
        val userId = getNextUserId()
        val profile = UserProfile.default(userId, username)

        val doc = PlayerAccount(
            userId = userId,
            hashedPassword = hashPw(password),
            profile = profile,
            metadata = ServerMetadata()
        )
        val obj = PlayerData.newGame(userId, username)

        accountCollection.insertOne(doc)
        dataCollection.insertOne(obj)

        return userId
    }

    override suspend fun getNextUserId(): Long {
        return runMongoCatching {
            val existing = counter.find(Filters.eq("_id", "playerCounter")).firstOrNull()

            val doc = if (existing == null) {
                // No counter yet -> insert starting value
                counter.insertOne(PlayerCounter(_id = "playerCounter", seq = 100))
                PlayerCounter(_id = "playerCounter", seq = 100)
            } else {
                // Already exists -> increment
                counter.findOneAndUpdate(
                    Filters.eq("_id", "playerCounter"),
                    Updates.inc("seq", 1),
                    FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER)
                )!!
            }
            doc.seq
        }.getOrThrow()
    }

    private fun hashPw(password: String): String {
        return Base64.encode(Bcrypt.hash(password, 10))
    }

    override suspend fun shutdown() = Unit
}

/**
 * Executes the given [block] that returns a value of type [T] or null.
 *
 * - If [block] returns null, this will return a failed [Result] containing a [NoSuchElementException]
 *   with the provided [nullMessage].
 * - If [block] throws any exception, it will be caught and wrapped in a failed [Result].
 * - Otherwise, the returned non-null value is wrapped in a successful [Result].
 *
 * You need to throw exception explicitly if there are multiple exception messages.
 */
inline fun <T> runMongoCatching(
    nullMessage: String = "Document not found",
    block: () -> T?
): Result<T> {
    return try {
        val value = block()
        if (value == null) {
            Result.failure(NoSuchElementException(nullMessage))
        } else {
            Result.success(value)
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}

/**
 * Executes the given [block] that returns a [Boolean] indicating success.
 *
 * - If [block] returns false, this will return a failed [Result] containing a [NoSuchElementException]
 *   with the provided [failMessage].
 * - If [block] throws any exception, it will be caught and wrapped in a failed [Result].
 * - If [block] returns true, a successful [Result] with [Unit] is returned.
 *
 * You need to throw exception explicitly if there are multiple exception messages.
 */
inline fun runMongoCatchingUnit(
    failMessage: String = "Document not found",
    block: () -> Boolean
): Result<Unit> {
    return try {
        if (block()) Result.success(Unit)
        else Result.failure(NoSuchElementException(failMessage))
    } catch (e: Exception) {
        Result.failure(e)
    }
}

/**
 * Check whether update operation were matched and modified; and throw an error
 * if it's not.
 *
 * @param [userId] The DB operation for specific [userId].
 * @param info Additional info added to error message.
 *             Typically, add function or class name, or context about the operation
 * @throws NoSuchElementException if `matchedCount` is less than 1
 * @throws IllegalStateException if `modifiedCount` is less than 1
 */
fun UpdateResult.throwIfNotModified(userId: Long, info: String = "") {
    if (matchedCount < 1) {
        throw NoSuchElementException("userId=$userId not found; $info")
    }
    if (modifiedCount < 1) {
        throw IllegalStateException("Failed to update one for userId=$userId; $info")
    }
}
