package server.core

import io.ktor.util.date.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Keeps track the status of online players.
 */
class OnlinePlayerRegistry {
    private val players = ConcurrentHashMap<String, PlayerStatus>()

    /**
     * Mark a player of [userId] as online. Does nothing if the player is already online.
     */
    fun markOnline(userId: String) {
        val now = getTimeMillis()
        players[userId] = PlayerStatus(
            userId = userId,
            onlineSince = now,
            lastNetworkActivity = now,
        )
    }

    /**
     * Mark a player of [userId] as offline. Does nothing if the player is already offline.
     */
    fun markOffline(userId: String) {
        players.remove(userId)
    }

    /**
     * Update the last network activity of [userId]. Does nothing if the player is not online.
     */
    fun updateLastActivity(userId: String) {
        players.computeIfPresent(userId) { _, status ->
            status.copy(lastNetworkActivity = getTimeMillis())
        }
    }

    /**
     * Shutdown the registry by clearing the tracked players.
     */
    fun shutdown() {
        players.clear()
    }
}

/**
 * Represents the current online status of a player.
 *
 * @property onlineSince The timestamp (in milliseconds since epoch)
 *                       when the player came online.
 * @property lastNetworkActivity The timestamp (in milliseconds since epoch)
 *                               of the player's most recent network activity.
 */
data class PlayerStatus(
    val userId: String,
    val onlineSince: Long,
    val lastNetworkActivity: Long,
)
