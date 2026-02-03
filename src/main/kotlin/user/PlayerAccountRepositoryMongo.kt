package user

import com.mongodb.client.model.Filters
import com.mongodb.client.model.Projections
import com.mongodb.client.model.Updates
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.toxicbakery.bcrypt.Bcrypt
import data.collection.PlayerAccount
import data.runMongoCatching
import data.throwIfNotModified
import kotlinx.coroutines.flow.firstOrNull
import org.bson.Document
import kotlin.io.encoding.Base64

class PlayerAccountRepositoryMongo(val accountCollection: MongoCollection<PlayerAccount>) : PlayerAccountRepository {
    override suspend fun getPlayerAccountByName(username: String): Result<PlayerAccount> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("profile.displayName", username))
                .projection(null)
                .firstOrNull()
        }
    }

    override suspend fun getPlayerAccountById(userId: Long): Result<PlayerAccount> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("userId", userId))
                .projection(null)
                .firstOrNull()
        }
    }

    override suspend fun getUserIdFromName(username: String): Result<String> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("profile.displayName", username))
                .projection(null)
                .firstOrNull()
                ?.userId
        }
    }

    override suspend fun doesUsernameExist(username: String): Result<Boolean> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("profile.displayName", username))
                .projection(null)
                .firstOrNull() != null
        }
    }

    override suspend fun isUsernameAvailable(username: String): Result<Boolean> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("profile.displayName", username))
                .projection(null)
                .firstOrNull() == null
        }
    }

    override suspend fun doesEmailExist(email: String): Result<Boolean> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("profile.email", email))
                .projection(null)
                .firstOrNull() != null
        }
    }

    override suspend fun isEmailAvailable(email: String): Result<Boolean> {
        return runMongoCatching {
            accountCollection
                .find(Filters.eq("profile.email", email))
                .projection(null)
                .firstOrNull() == null
        }
    }

    override suspend fun updatePlayerAccount(
        userId: Long,
        account: PlayerAccount
    ): Result<Unit> {
        return runMongoCatching {
            val result = accountCollection.replaceOne(Filters.eq("userId", userId), account)
            result.throwIfNotModified(userId, "PlayerAccount updatePlayerAccount")
        }
    }

    override suspend fun updateLastLogin(userId: Long, lastLogin: Long): Result<Unit> {
        return runMongoCatching {
            val result = accountCollection.updateOne(
                Filters.eq("userId", userId),
                Updates.set("profile.lastLogin", lastLogin)
            )
            result.throwIfNotModified(userId, "PlayerAccount updateLastLogin")
        }
    }

    override suspend fun verifyCredentials(username: String, password: String): Result<String> {
        return runMongoCatching {
            val doc = accountCollection
                .withDocumentClass<Document>()
                .find(Filters.eq("profile.displayName", username))
                .projection(Projections.include("hashedPassword", "userId"))
                .firstOrNull()

            if (doc == null) return@runMongoCatching null

            val hashed = doc.getString("hashedPassword")
            val userId = doc.getString("userId")
            val matches = Bcrypt.verify(password, Base64.decode(hashed))

            if (matches) userId else null
        }
    }
}
