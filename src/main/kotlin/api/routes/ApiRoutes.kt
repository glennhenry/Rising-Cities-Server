package api.routes

import SERVER_ADDRESS
import SERVER_SOCKET_PORT
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import utils.JSON
import utils.logging.Logger
import kotlin.collections.component1
import kotlin.collections.component2

val rcapiResponse = JSON.encode(mapOf("host" to SERVER_ADDRESS, "port" to SERVER_SOCKET_PORT))

fun Route.apiRoutes() {
    get("/RCApi") {
        Logger.debug {
            "RCApi request params: ${
                call.request.queryParameters.entries()
                    .joinToString(", ") { (k, v) -> "$k=${v.joinToString("|")}" }
            }"
        }

        call.respond(rcapiResponse)
    }
}
