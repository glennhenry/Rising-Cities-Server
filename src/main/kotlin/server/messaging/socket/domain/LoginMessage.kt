package server.messaging.socket.domain

import kotlinx.serialization.Serializable
import server.messaging.socket.RCMessage
import server.messaging.socket.RCResponse

/**
 * `ClientMessageLoginCommand.as`
 * @property uid userId
 * @property ses Session identifier
 */
@Serializable
data class LoginRequest(val uid: String, val ses: String) : RCMessage {
    override val header = "LOGIN"
}

@Serializable
data class LoginResponse(val uid: String, val ses: String) : RCResponse {
    override val header: String = "LOGIN"
}
