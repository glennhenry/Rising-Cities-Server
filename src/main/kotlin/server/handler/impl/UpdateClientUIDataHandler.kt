package server.handler.impl

import context.ServerContext
import server.handler.HandlerContext
import server.handler.SocketMessageHandler
import server.messaging.ClientMessage
import server.messaging.socket.domain.UpdateClientUIDataRequest
import utils.logging.Logger
import kotlin.reflect.KClass

class UpdateClientUIDataHandler(private val serverContext: ServerContext): SocketMessageHandler<UpdateClientUIDataRequest> {
    override val name: String = "UpdateClientUIDataHandler"
    override val messageType: String = ClientMessage.UPDATE_CLIENT_UI_DATA
    override val expectedMessageClass: KClass<UpdateClientUIDataRequest> = UpdateClientUIDataRequest::class

    override suspend fun handle(ctx: HandlerContext<UpdateClientUIDataRequest>) {
        // server should save UI update (we will skip saving for now)
        // The UI data should be sent back if it's mutated in the server
        Logger.info { "Received Client UI data update (not modified)" }
    }
}
