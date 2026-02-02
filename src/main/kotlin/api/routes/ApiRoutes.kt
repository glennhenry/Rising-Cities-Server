package api.routes

import SERVER_ADDRESS
import SERVER_SOCKET_PORT
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.contentType
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.util.date.getTimeMillis
import io.netty.handler.codec.base64.Base64Decoder
import utils.logging.Logger
import java.util.zip.Inflater
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.io.encoding.Base64
import kotlin.time.Duration.Companion.minutes

const val rcapiResponse = """{"host":"$SERVER_ADDRESS","port":$SERVER_SOCKET_PORT}"""

fun Route.apiRoutes() {
    var lastLog: Long? = null

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
        val compressed = call.receive<ByteArray>()

        if (lastLog == null || (getTimeMillis() - lastLog!!).minutes > 1.minutes) {
            Logger.debug { "Client POST to /debug: ${decompress(compressed)}" }
            lastLog = getTimeMillis()
        }

        call.respond(HttpStatusCode.OK)
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
