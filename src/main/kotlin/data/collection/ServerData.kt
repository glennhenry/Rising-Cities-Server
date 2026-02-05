package data.collection

import kotlinx.serialization.Serializable

/**
 * Database-level representation of server-wide data.
 *
 * This collection stores global, non–player-specific information such as leaderboards or
 * clan data.
 */
@Serializable
data class ServerData(
    val example: String = "REPLACE"
)
