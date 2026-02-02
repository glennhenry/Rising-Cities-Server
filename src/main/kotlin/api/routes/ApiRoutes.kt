package api.routes

import SERVER_ADDRESS
import SERVER_SOCKET_PORT
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.contentType
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import utils.logging.Logger
import kotlin.collections.component1
import kotlin.collections.component2

const val rcapiResponse = """{"host":"$SERVER_ADDRESS","port":$SERVER_SOCKET_PORT}"""

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

	post("/debug") {
		val bytes = call.receive<ByteArray>()

		Logger.debug {
			buildString {
				appendLine("=== /debug POST ===")
				appendLine("Content-Type: ${call.request.contentType()}")
				appendLine("Content-Length: ${bytes.size}")
				appendLine("Headers:")
				call.request.headers.forEach { k, v ->
					appendLine("  $k = $v")
				}
			}
		}

		try {
			Logger.debug { "Body (UTF-8): ${bytes.toString(Charsets.UTF_8)}" }
		} catch (_: Throwable) {
			Logger.debug { "Body not UTF-8 (likely compressed)" }
		}

		call.respond(HttpStatusCode.OK)
	}
}
