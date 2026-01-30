package server.handler.impl

import server.handler.HandlerContext
import server.handler.SocketMessageHandler
import server.messaging.ClientMessage
import server.messaging.socket.domain.LoginRequest
import utils.logging.Logger
import kotlin.reflect.KClass

class LoginHandler : SocketMessageHandler<LoginRequest> {
    override val name: String = "LoginHandler"
    override val messageType: String = ClientMessage.LOGIN
    override val expectedMessageClass: KClass<LoginRequest> = LoginRequest::class

    override suspend fun handle(ctx: HandlerContext<LoginRequest>) {
        Logger.info { "${ctx.message}" }
    }
}
