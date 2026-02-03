package api.routes

import context.ServerContext
import core.data.AdminData
import core.data.FlashConfig
import core.data.FlashVars
import utils.logging.Logger
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import user.model.UserSession
import kotlin.io.encoding.Base64

fun Route.webLoginRoutes(serverContext: ServerContext, adminEnabled: Boolean) {
    post("/api/login") {
        val data = call.receive<Map<String, String>>()
        val username = data["username"]
        val password = data["password"]

        if (username == null || password == null) {
            call.respond(HttpStatusCode.BadRequest, mapOf("reason" to "Missing credentials"))
            return@post
        }

        if (username == AdminData.ADMIN_RESERVED_NAME) {
            if (adminEnabled) {
                val session = serverContext.authProvider.adminLogin()
                Logger.info { "Done web admin login" }
                call.respond(HttpStatusCode.OK, json.encodeToString(createLoginSuccessResponse(session)))
            } else {
                call.respond(HttpStatusCode.Forbidden, mapOf("reason" to "admin account not enabled"))
            }
            return@post
        }

        val usernameExist = serverContext.authProvider.doesUsernameExist(username)
        if (usernameExist) {
            val loginResult = serverContext.authProvider.login(username, password)

            if (loginResult.isFailure) {
                Logger.info { "Web login failed for username '$username': ${loginResult.exceptionOrNull()?.message}" }

                call.respond(
                    HttpStatusCode.Unauthorized,
                    mapOf("reason" to "login failed: ${loginResult.exceptionOrNull()?.message}")
                )
                return@post
            } else {
                val loginSession = loginResult.getOrNull()
                val passwordRight = loginSession != null
                if (passwordRight) {
                    Logger.info { "Web login result of username '$username': success" }
                    call.respond(HttpStatusCode.OK, json.encodeToString(createLoginSuccessResponse(loginSession)))
                } else {
                    Logger.info { "Web login result of username '$username': password wrong" }
                    call.respond(
                        HttpStatusCode.Unauthorized,
                        mapOf("reason" to "wrong password or account don't exist")
                    )
                }
            }
        } else {
            val registerResult = serverContext.authProvider.register(username, password)

            if (registerResult.isFailure) {
                Logger.info { "Web register failed for username '$username': ${registerResult.exceptionOrNull()?.message}" }

                call.respond(
                    HttpStatusCode.Unauthorized,
                    mapOf("reason" to "register failed: ${registerResult.exceptionOrNull()?.message}")
                )
                return@post
            } else {
                val session = registerResult.getOrNull()
                if (session != null) {
                    Logger.info { "Web register result of username '$username': success=${registerResult.isSuccess}" }
                    call.respond(HttpStatusCode.OK, json.encodeToString(createLoginSuccessResponse(session)))
                } else {
                    Logger.info { "Web register success but session is null for '$username'" }
                }
            }
        }
    }

    get("/api/userexist") {
        val username = call.parameters["username"]
        if (username.isNullOrBlank()) {
            call.respondText("no", status = HttpStatusCode.BadRequest)
            return@get
        }

        if (username == AdminData.ADMIN_RESERVED_NAME) {
            if (adminEnabled) {
                call.respondText("granted")
            } else {
                call.respondText("reserved")
            }
            return@get
        }

        try {
            val exists = serverContext.authProvider.doesUsernameExist(username)
            call.respondText(if (exists) "yes" else "no")
        } catch (e: Exception) {
            Logger.error { "Failed to check if user exists: $username, e.message:${e.message}" }
            call.respond(HttpStatusCode.InternalServerError, mapOf("reason" to "Database error"))
        }
    }
}

@Serializable
data class WebLoginSuccessResponse(
    val userId: Long, val token: String, val flash: FlashConfig
)

fun createLoginSuccessResponse(session: UserSession): WebLoginSuccessResponse {
    return WebLoginSuccessResponse(
        userId = session.userId,
        token = session.token,
        flash = FlashConfig(
            flashVars = populateFlashVars(
                session.userId,
                session.token,
                generateClientContext(EventStreamClientContext(session.userId))
            )
        )
    )
}

// add more as needed
@Serializable
data class EventStreamClientContext(
    val userId: Long
)

val json = Json {
    prettyPrint = false
    encodeDefaults = true
}

/**
 * `EventStreamClient.as` periodically stream client's event to server.
 * It is able to send "client context", which is client's information
 * initially sent by server. This client information is a generic object
 * and can contain anything.
 *
 * The client info has special encoding:
 * 1. Raw client data is a JSON encoded string.
 * 2. Encode the data again with Base64.
 */
fun generateClientContext(context: EventStreamClientContext): String {
    return Base64.encode(json.encodeToString(context).toByteArray())
}

fun populateFlashVars(userId: Long, sessionId: String, eventStream: String): FlashVars {
    return FlashVars(uid = userId, sid = sessionId, eventStream = eventStream)
}
