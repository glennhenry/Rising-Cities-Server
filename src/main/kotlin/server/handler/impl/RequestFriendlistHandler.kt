package server.handler.impl

import server.handler.HandlerContext
import server.handler.SocketMessageHandler
import server.messaging.ClientMessage
import server.messaging.socket.EmptyRCMessage
import utils.logging.Logger
import kotlin.reflect.KClass

class RequestFriendlistHandler : SocketMessageHandler<EmptyRCMessage> {
    override val name: String = "RequestFriendlistHandler"
    override val messageType: String = ClientMessage.SLAYER_INVITE_REQUEST_FRIENDLIST
    override val expectedMessageClass: KClass<EmptyRCMessage> = EmptyRCMessage::class

    override suspend fun handle(ctx: HandlerContext<EmptyRCMessage>) {
        Logger.info { "Got ${ClientMessage.SLAYER_INVITE_REQUEST_FRIENDLIST} message (ignored)" }
    }
}
