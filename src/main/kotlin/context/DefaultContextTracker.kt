package context

import com.mongodb.kotlin.client.coroutine.MongoCollection
import data.Database
import data.collection.PlayerData
import server.core.network.Connection
import java.util.concurrent.ConcurrentHashMap

/**
 * Default implementation of [ContextTracker] which is based on real player
 * [Connection] and [Database].
 */
class DefaultContextTracker: ContextTracker {
    private val players = ConcurrentHashMap<Long, PlayerContext>()

    /**
     * Creates and registers a new [PlayerContext] for the given player.
     *
     * This function loads the player's account from the [Database], initializes
     * the associated [PlayerServices], and stores the resulting context in [players].
     *
     * @param userId The unique identifier of the player.
     * @param connection The player's active network [Connection].
     * @param db The [Database] instance used to load account data and initialize services.
     *
     * @throws IllegalArgumentException If the player's account data cannot be found.
     */
    override suspend fun createContext(
        userId: Long,
        connection: Connection,
        db: Database
    ) {
        val playerAccount =
            requireNotNull(db.loadPlayerAccount(userId)) { "Missing PlayerAccount for userId=$userId" }

        val context = PlayerContext(
            userId = userId,
            connection = connection,
            account = playerAccount,
            services = initializeServices(userId, db)
        )
        players[userId] = context
    }

    private suspend fun initializeServices(
        userId: Long,
        db: Database,
    ): PlayerServices {
        val playerDataCollection = db.getCollection<MongoCollection<PlayerData>>("player_data")

        return PlayerServices(
            example = ""
        )
    }

    override fun getContext(userId: Long): PlayerContext? {
        return players[userId]
    }

    override fun removeContext(userId: Long) {
        players.remove(userId)
    }

    override suspend fun shutdown() {
        players.values.forEach {
            it.connection.shutdown()
        }
        players.clear()
    }
}
