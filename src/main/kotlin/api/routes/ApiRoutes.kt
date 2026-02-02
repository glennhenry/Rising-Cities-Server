package api.routes

import SERVER_ADDRESS
import SERVER_SOCKET_PORT
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import utils.logging.Logger
import java.util.zip.Inflater

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

    post("/eventstream") {
        val bytes = call.receive<ByteArray>()
        val json = decompress(bytes)
        Logger.debug(logFull = false) { "POST to /eventstream: $json" }
        call.respondText("OK", ContentType.Text.Plain, HttpStatusCode.OK)
    }

    post("/debug") {
        val params = call.receiveParameters()

        val playerId = params["playerId"]
        val message = params["message"]
        val logLevel = params["logLevel"]

        Logger.debug(logFull = false) {
            buildString {
                appendLine("POST to /debug (playerId=$playerId, logLevel=$logLevel)")
                appendLine(message)
            }
        }

        call.respondText("OK", ContentType.Text.Plain, HttpStatusCode.OK)
    }
}

fun decompress(bytes: ByteArray): String {
    val inflater = Inflater()
    inflater.setInput(bytes)
    val output = ByteArray(8192)
    val decompressed = StringBuilder()
    while (!inflater.finished()) {
        val count = inflater.inflate(output)
        decompressed.append(String(output, 0, count, Charsets.UTF_8))
    }
    inflater.end()
    return decompressed.toString()
}
