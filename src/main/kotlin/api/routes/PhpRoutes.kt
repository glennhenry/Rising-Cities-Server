package api.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.uri
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import utils.logging.Logger

val stubCatResponse = """
    {
        "items": []
    }
""".trimIndent()

/**
 * To handle those API request with PHP syntax (ktor treat them as malformed).
 * These URLs often has no path and just query params directly (supposed to respond
 * from URL that doesn't end with '/' like xxx.index.php?abc=1&abc=2).
 */
fun Route.phpRoutes() {
    get("{...}") {
        val uri = call.request.uri

        // e.g., /&cat=4&price
        if (uri.startsWith("/&")) {
            val fakeQuery = uri.removePrefix("/&")

            val params = fakeQuery
                .split("&")
                .mapNotNull {
                    val parts = it.split("=", limit = 2)
                    when (parts.size) {
                        2 -> parts[0] to parts[1] // "cat=4"
                        1 -> parts[0] to ""       // flags like "&price"
                        else -> null
                    }
                }
                .toMap()

            when {
                params.containsKey("cat") && params.containsKey("price") -> {
                    // cat request of price
                    val cat = params["cat"]
                    val price = params.containsKey("price")

                    Logger.debug { "Got cat request with cat=$cat price=$price" }

                    call.respond(stubCatResponse)
                }

                else -> call.respond(HttpStatusCode.NotFound)
            }
        } else {
            Logger.warn { "Got wildcard request but doesn't start with /&: $uri" }
        }

        call.respond(HttpStatusCode.NotFound)
    }
}
