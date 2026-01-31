package server.handler.impl

import annotation.RevisitLater
import core.data.ResourceConstants
import core.model.config.ConfigDTO
import core.model.config.ConfigResourceDTO
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

    override suspend fun handle(ctx: HandlerContext<LoginRequest>) = with(ctx) {
        Logger.info { "Received ${ctx.message}." }
    }

    @RevisitLater(
        "Config is hardcoded. " +
                "Should be replaced with JSON file configuration. " +
                "(pre-read config file -> register in GameDefinition " +
                "-> convert to DTOs [with defaults field]) " +
                "to allow changing config without changing the code."
    )
    private fun buildConfig(): ConfigDTO {
        return ConfigDTO(
            configResources = listOf(
                ConfigResourceDTO(
                    id = 1,
                    type = ResourceConstants.RESOURCE_WORKERS,
                ),
                ConfigResourceDTO(
                    id = 2,
                    type = ResourceConstants.RESOURCE_RICHMEN,
                ),
                ConfigResourceDTO(
                    id = 3,
                    type = ResourceConstants.RESOURCE_ACADEMICS,
                ),
                ConfigResourceDTO(
                    id = 4,
                    type = ResourceConstants.RESOURCE_HAPPINESS_NEGATIVE,
                ),
                ConfigResourceDTO(
                    id = 5,
                    type = ResourceConstants.RESOURCE_HAPPINESS_POSITIVE,
                ),
                ConfigResourceDTO(
                    id = 6,
                    type = ResourceConstants.RESOURCE_ENERGY_NEGATIVE,
                ),
                ConfigResourceDTO(
                    id = 7,
                    type = ResourceConstants.RESOURCE_ENERGY_POSITIVE,
                ),
            )
        )
    }
}
