package data.collection

import core.data.AdminData
import core.model.PlayerDTO
import kotlinx.serialization.Serializable

/**
 * Database-level representation of a player's game data.
 */
@Serializable
data class PlayerData(
    val userId: Long,
    val playerDTO: PlayerDTO
) {
    companion object {
        // admin data not complete (still same as newGame)
        fun admin(): PlayerData {
            return PlayerData(
                userId = AdminData.USER_ID,
                playerDTO = PlayerDTO.admin()
            )
        }

        fun newGame(userId: Long, username: String): PlayerData {
            return PlayerData(
                userId = userId,
                playerDTO = PlayerDTO.newGame(userId, username)
            )
        }
    }
}
