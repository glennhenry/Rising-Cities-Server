package data

import com.mongodb.kotlin.client.coroutine.MongoCollection
import data.collection.PlayerAccount
import data.collection.PlayerData
import data.collection.ServerData

/**
 * Empty implementation (no operation) of [Database] only used for testing purposes.
 */
class EmptyDatabase : Database {
    override suspend fun loadPlayerAccount(userId: Long): PlayerAccount = TODO("ONLY TEST")
    override suspend fun loadPlayerData(userId: Long): PlayerData = TODO("ONLY TEST")
    override suspend fun loadServerData(): ServerData = TODO("ONLY TEST")
    override fun <T : Any> getCollection(name: String): MongoCollection<T> = TODO("ONLY TEST")
    override suspend fun createPlayer(username: String, password: String): Long = TODO("ONLY TEST")
    override suspend fun getNextUserId(): Long = TODO("ONLY TEST")
    override suspend fun shutdown() = TODO("ONLY TEST")
}
