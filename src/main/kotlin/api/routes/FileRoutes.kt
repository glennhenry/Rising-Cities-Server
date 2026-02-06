package api.routes

import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import utils.logging.Logger
import java.io.File

val iconOffset = """
    <?xml version="1.0" encoding="UTF-8"?>
    <iconOffsets>
    </iconOffsets>
""".trimIndent()

val xmlStub = """
    <?xml version="1.0" encoding="UTF-8"?>
    <root>
    </root>
""".trimIndent()

fun Route.fileRoutes() {
    get("/") {
        call.respondFile(File("static/index.html"))
    }
    staticFiles("site", File("static/site"))
    staticFiles("game", File("static/game"))
    staticFiles("/xml", File("static/game/xml")) {
        fallback { string, call ->
            Logger.debug { "Request to /xml/$string (fallback response)" }
            val file = File("static/game/xml", string)
            if (string.contains("iconOffset")) {
                file.writeText(iconOffset)
                call.respondFile(file)
            } else {
                file.writeText(xmlStub)
                call.respondFile(file)
            }
        }
    }

    staticFiles("/swf", File("static/game/swf")) {
        fallback { string, call ->
            Logger.debug { "Request to /swf/$string (fallback response)" }
            call.respondFile(File("static/game/Main.swf"))
        }
    }

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

    get("/crossdomain.xml") {
        call.respondFile(File("static/crossdomain.xml"))
    }

    get("/debug/crossdomain.xml") {
        call.respondFile(File("static/crossdomain.xml"))
    }
}
