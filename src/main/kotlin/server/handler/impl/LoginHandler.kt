package server.handler.impl

import annotation.RevisitLater
import context.ServerContext
import core.model.CityDTO
import core.model.PlayerDTO
import core.model.config.ConfigDTO
import core.model.config.ConfigResourceDTO
import core.model.constants.ResourceConstants
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import server.handler.HandlerContext
import server.handler.SocketMessageHandler
import server.messaging.ClientMessage
import server.messaging.ServerMessage
import server.messaging.format.RCSerializer
import server.messaging.socket.domain.LoginRequest
import utils.JsonGenerator
import utils.JsonGenerator.CollectionPolicy
import utils.JsonGenerator.GenerationPolicy
import utils.JsonGenerator.KeyPolicy
import utils.JsonGenerator.ValuePolicy
import utils.functions.charPool
import utils.functions.randomString
import utils.logging.Logger
import java.io.File
import kotlin.random.Random
import kotlin.reflect.KClass

class LoginHandler(private val serverContext: ServerContext) : SocketMessageHandler<LoginRequest> {
    override val name: String = "LoginHandler"
    override val messageType: String = ClientMessage.LOGIN
    override val expectedMessageClass: KClass<LoginRequest> = LoginRequest::class
    private val configJsonResponse = File("static/game/config.json").readText()
    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
        prettyPrint = false
    }
    val policy = GenerationPolicy(
        collections = CollectionPolicy.ONE,
        values = ValuePolicy(
            int = { Random.nextInt(1, 100000) },
            uint = { Random.nextInt(1, 100000).toUInt() },
            long = { Random.nextLong(1, 100000) },
            string = { randomString(Random.nextInt(4, 8), charPool) },
            boolean = { Random.nextBoolean() },
            float = { Random.nextFloat() },
            double = { Random.nextDouble() }
        ),
        keys = KeyPolicy(
            int = { Random.nextInt(1, 100000).toString() },
            uint = { Random.nextInt(1, 100000).toString() },
            long = { Random.nextLong(1, 100000).toString() },
            string = { randomString(Random.nextInt(4, 8), charPool) },
            boolean = { Random.nextBoolean().toString() }
        )
    )

    @RevisitLater("Don't generate PlayerDTO and CityDTO, should load from DB instead")
    override suspend fun handle(ctx: HandlerContext<LoginRequest>) = with(ctx) {
        // verify ses (session) string
        val verified = serverContext.sessionManager.verify(message.ses)
        if (verified) {
            Logger.info { "Received ${ctx.message}: token valid" }
        } else {
            Logger.info { "Received ${ctx.message}: token invalid" }
            return@with
        }

        // mark player as online, assign userId to Connection object
        serverContext.onlinePlayerRegistry.markOnline(message.uid)
        updateUserId(message.uid)

        // ...load from each player's DB
        // val player = PlayerDTO()
        // val response = RCSerializer.serialize(LoginResponse(config, player))

        val playerJson = JsonGenerator.generate<PlayerDTO>(json, policy)
        val playerElement = json.parseToJsonElement(playerJson)
        val configElement = json.parseToJsonElement(configJsonResponse)

        val responseJson = buildJsonObject {
            put("config", configElement)
            put("player", playerElement)
        }

        val response = RCSerializer.serializeEncoded(
            ServerMessage.SERVER_MESSAGE_INITIAL_LOGIN_SUCCESS,
            json.encodeToString(JsonElement.serializer(), responseJson)
        )

        sendRaw(response)

        // city update
        val cityJson = JsonGenerator.generate<CityDTO>(json, policy)
        val cityElement = json.parseToJsonElement(cityJson)
        val responseJson2 = buildJsonObject {
            put("c", cityElement)
        }
        val response2 = RCSerializer.serializeEncoded(
            ServerMessage.SERVER_MESSAGE_PLAYER_CITY_UPDATE,
            json.encodeToString(JsonElement.serializer(), responseJson2)
        )
        sendRaw(response2)
    }

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
