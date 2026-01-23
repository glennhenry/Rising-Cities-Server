package api.routes

import SERVER_ADDRESS
import SERVER_SOCKET_PORT
import io.ktor.http.HttpStatusCode
import io.ktor.server.http.content.staticFiles
import io.ktor.server.request.httpMethod
import io.ktor.server.request.uri
import io.ktor.server.response.respond
import io.ktor.server.response.respondFile
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import utils.JSON
import utils.logging.Logger
import java.io.File

fun Route.fileRoutes() {
    get("/") {
        call.respondFile(File("static/index.html"))
    }
    staticFiles("site", File("static/site"))
    staticFiles("game", File("static/game"))
    staticFiles("/xml", File("static/game/xml"))

    get("/docs") {
        val docsIndex = File("docs/index.html")
        if (docsIndex.exists()) {
            call.respondFile(docsIndex)
        } else {
            call.respond(
                HttpStatusCode.NotFound,
                "Only available in production; Please start the docs using vite server or build the server first."
            )
        }
    }

    staticFiles("docs", File("docs"))

    get("/locale/{code}/{filename}") {
        val code = call.parameters["code"]
            ?: return@get call.respond(HttpStatusCode.BadRequest)
        val filename = call.parameters["filename"]
            ?: return@get call.respond(HttpStatusCode.BadRequest)

        val file = File("static/game/locale/$code/$filename")

        if (!file.exists() || !file.isFile) {
            return@get call.respond(HttpStatusCode.NotFound)
        }

        call.respondFile(file)
    }

    get("/RCApi") {
        Logger.debug {
            "RCApi request params: ${
                call.request.queryParameters.entries()
                    .joinToString(", ") { (k, v) -> "$k=${v.joinToString("|")}" }
            }"
        }

        val response = mapOf("host" to SERVER_ADDRESS, "port" to SERVER_SOCKET_PORT)
        call.respond(JSON.encode(response))
    }
}
