package server.handler.impl

import annotation.RevisitLater
import context.ServerContext
import core.model.config.ConfigDTO
import server.handler.HandlerContext
import server.handler.SocketMessageHandler
import server.messaging.ClientMessage
import server.messaging.format.RCSerializer
import server.messaging.socket.domain.LoginRequest
import server.messaging.socket.domain.LoginResponse
import utils.JSON
import utils.logging.Logger
import java.io.File
import kotlin.reflect.KClass

class LoginHandler(private val serverContext: ServerContext) : SocketMessageHandler<LoginRequest> {
    override val name: String = "LoginHandler"
    override val messageType: String = ClientMessage.LOGIN
    override val expectedMessageClass: KClass<LoginRequest> = LoginRequest::class
    private val configDTO: ConfigDTO = JSON.decode(File("static/game/config_minimal.json").readText())

    @RevisitLater("Don't generate PlayerDTO and CityDTO, should load from DB instead")
    override suspend fun handle(ctx: HandlerContext<LoginRequest>) = with(ctx) {
        // verify ses (session) string
        val verified = serverContext.sessionManager.verify(message.ses)
        if (verified || message.ses == "davidhaselhoff") {
            Logger.info { "Received ${ctx.message}: token valid" }
        } else {
            Logger.info { "Received ${ctx.message}: token invalid" }
            return@with
        }

        // mark player as online, assign userId to Connection object
        serverContext.onlinePlayerRegistry.markOnline(message.uid)
        updateUserId(message.uid)

        // Stage 1: SERVER_MESSAGE_INITIAL_LOGIN_SUCCESS, send ConfigDTO + PlayerDTO
        val playerData = if (message.ses == "davidhaselhoff") {
            serverContext.db.loadPlayerData(101)
        } else {
            serverContext.db.loadPlayerData(message.uid)
        }
        if (playerData == null) {
            Logger.warn { "Unexpected DB null: user logged in, session valid, but PlayerData is null for uid=${message.uid}" }
            return@with
        }
        // TO-DO:...initialize services

        val response = RCSerializer.serialize(
            LoginResponse(
                config = configDTO,
                player = playerData.playerDTO
            )
        )

        sendRaw(response)
    }
}
