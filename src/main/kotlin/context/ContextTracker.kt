package context

import data.Database
import server.core.network.Connection

/**
 * Represent tracker for [PlayerContext] of all connected players.
 *
 * This class is responsible for:
 * - Creating new [PlayerContext] instances.
 * - Creating a context includes initializing all [PlayerServices] for each player.
 * - Storing active player contexts for lookup and management during gameplay.
 */
interface ContextTracker {
    /**
     * Creates and registers a new [PlayerContext] for the given player.
     */
    suspend fun createContext(
        userId: String,
        connection: Connection,
        db: Database
    )

    /**
     * Get context of [userId].
     */
    fun getContext(userId: String): PlayerContext?

    /**
     * Remove context of [userId].
     */
    fun removeContext(userId: String)

    /**
     * Shutdown the tracker.
     */
    suspend fun shutdown()
}
