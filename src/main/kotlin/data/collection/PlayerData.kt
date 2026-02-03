package data.collection

import core.data.AdminData

/**
 * Database-level representation of a player's game data.
 */
data class PlayerData(
    val userId: Long,
) {
    companion object {
        fun admin(): PlayerData {
            return PlayerData(
                userId = AdminData.USER_ID
            )
        }

        fun newGame(userId: Long): PlayerData {
            return PlayerData(
                userId = userId
            )
        }
    }
}
