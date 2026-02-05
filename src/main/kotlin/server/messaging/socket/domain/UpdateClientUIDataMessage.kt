package server.messaging.socket.domain

import core.model.ClientUIDataDTO
import kotlinx.serialization.Serializable
import server.messaging.ClientMessage
import server.messaging.ServerMessage
import server.messaging.socket.RCMessage
import server.messaging.socket.RCResponse

@Serializable
data class UpdateClientUIDataRequest(
    val dat: ClientUIDataDTO
) : RCMessage {
    override val header: String = ClientMessage.UPDATE_CLIENT_UI_DATA
}

@Serializable
data class UpdateClientUIDataResponse(
    val dat: ClientUIDataDTO
): RCResponse {
    override val header: String = ServerMessage.SERVER_MESSAGE_UPDATE_CLIENT_UI_DATA_SUCCESS
}
