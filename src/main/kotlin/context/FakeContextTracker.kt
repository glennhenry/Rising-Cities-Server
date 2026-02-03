package context

import data.Database
import server.core.network.Connection
import java.util.concurrent.ConcurrentHashMap

/**
 * Fake implementation of context tracker for testing purposes.
 *
 * This tracker does not implement method of [ContextTracker]. It instead use
 * [fakeContext] to easily register context for a player.
 */
class FakeContextTracker : ContextTracker {
    val players = ConcurrentHashMap<String, PlayerContext>()

    override suspend fun createContext(userId: String, connection: Connection, db: Database) = TODO("SHOULD NOT BE USED")

    fun fakeContext(ctx: PlayerContext) {
        players[ctx.userId] = ctx
    }

    override fun getContext(userId: String): PlayerContext? {
        return players.get(userId)
    }

    override fun removeContext(userId: String) {
        players.remove(userId)
    }

    override suspend fun shutdown() = Unit
}
