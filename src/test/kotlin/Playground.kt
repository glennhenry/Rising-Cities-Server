import kotlinx.serialization.json.Json
import server.messaging.socket.domain.LoginResponse
import utils.JsonGenerator
import utils.JsonGenerator.CollectionPolicy
import utils.JsonGenerator.GenerationPolicy
import utils.JsonGenerator.KeyPolicy
import utils.JsonGenerator.ValuePolicy
import utils.logging.Logger
import utils.randomString
import kotlin.random.Random
import kotlin.test.Test

/**
 * serve no test purpose, just to run code without running server app
 *
 * `.\gradlew test --tests "Playground" --console=rich`
 */
class Playground {
    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    @Test
    fun run1() {
        val charPool = ('a'..'z') + ('A'..'Z')

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

        val login = JsonGenerator.generate<LoginResponse>(json, policy)
        Logger.info(logFull = true) { "\n$login\n" }
    }
}
