package data.collection

import core.data.AdminData

/**
 * Database-level representation of a player's game data.
 */
data class PlayerData(
    val userId: String,
) {
    companion object {
        fun admin(): PlayerData {
            return PlayerData(
                userId = AdminData.PLAYER_ID
            )
        }

        fun newGame(userId: String): PlayerData {
            return PlayerData(
                userId = userId
            )
        }
    }
}
