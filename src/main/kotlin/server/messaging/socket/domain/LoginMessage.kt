package server.messaging.socket.domain

import core.model.config.ConfigDTO
import core.model.PlayerDTO
import kotlinx.serialization.Serializable
import server.messaging.ClientMessage
import server.messaging.ServerMessage
import server.messaging.socket.RCMessage
import server.messaging.socket.RCResponse

/**
 * `ClientMessageLoginCommand.as`
 * @property uid userId
 * @property ses Session identifier
 */
@Serializable
data class LoginRequest(val uid: Long, val ses: String) : RCMessage {
    override val header = ClientMessage.LOGIN
}

/**
 * what is needed so far:
 * - config.r -> resourceIds
 * - every player field
 */
@Serializable
data class LoginResponse(
    val config: ConfigDTO,
    val player: PlayerDTO
) : RCResponse {
    override val header: String = ServerMessage.SERVER_MESSAGE_INITIAL_LOGIN_SUCCESS
}
