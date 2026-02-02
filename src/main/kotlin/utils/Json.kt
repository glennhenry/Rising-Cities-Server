@file:Suppress("UNCHECKED_CAST")

package utils

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.SerialKind
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.PrimitiveKind
import utils.logging.Logger

/**
 * Preset JSON serialization and deserialization.
 */
@Suppress("unused")
object JSON {
    lateinit var json: Json

    fun initialize(json: Json) {
        this.json = json
    }

    inline fun <reified T> encode(value: T): String {
        return json.encodeToString<T>(value)
    }

    inline fun <reified T> encode(serializer: SerializationStrategy<T>, value: T): String {
        return json.encodeToString(serializer, value)
    }

    inline fun <reified T> decode(value: String): T {
        return json.decodeFromString<T>(value)
    }

    inline fun <reified T> decode(deserializer: DeserializationStrategy<T>, value: String): T {
        return json.decodeFromString(deserializer, value)
    }
}

@Suppress("unused")
fun parseJsonToMap(json: String): Map<String, Any?> {
    return try {
        val parsed = JSON.decode<JsonObject>(json)
        parsed.mapValues { (_, v) -> parseJsonElement(v) }
    } catch (_: Exception) {
        emptyMap()
    }
}

fun parseJsonElement(el: JsonElement): Any = when (el) {
    is JsonPrimitive -> {
        when {
            el.isString -> el.content
            el.booleanOrNull != null -> el.boolean
            el.intOrNull != null -> el.int
            el.longOrNull != null -> el.long
            el.doubleOrNull != null -> el.double
            else -> el.content
        }
    }

    is JsonObject -> el.mapValues { parseJsonElement(it.value) }
    is JsonArray -> el.map { parseJsonElement(it) }
}

fun Map<String, *>?.toJsonElement(): JsonObject = buildJsonObject {
    this@toJsonElement?.forEach { (key, value) ->
        put(key, value.toJsonValue())
    }
}

@OptIn(ExperimentalSerializationApi::class, InternalSerializationApi::class)
fun Any?.toJsonValue(prioritizeToString: Boolean = false): JsonElement = when (this) {
    null -> JsonNull
    is String -> JsonPrimitive(this)
    is Number -> JsonPrimitive(this)
    is Boolean -> JsonPrimitive(this)
    is Map<*, *> -> (this as? Map<String, *>)?.toJsonElement()
        ?: error("Map keys must be strings: $this")

    is Iterable<*> -> buildJsonArray { this@toJsonValue.forEach { add(it.toJsonValue()) } }
    is Pair<*, *> -> buildJsonObject {
        put("first", first.toJsonValue())
        put("second", second.toJsonValue())
    }

    is Triple<*, *, *> -> buildJsonObject {
        put("first", first.toJsonValue())
        put("second", second.toJsonValue())
        put("triple", third.toJsonValue())
    }

    else -> {
        if (prioritizeToString) {
            JsonPrimitive(this.toString())
        } else {
            val kClass = this::class
            val serializer = runCatching {
                JSON.json.serializersModule.getContextual(kClass) ?: kClass.serializer()
            }.getOrNull()

            when {
                serializer != null -> {
                    JSON.json.encodeToJsonElement(serializer as SerializationStrategy<Any>, this)
                }

                else -> {
                    Logger.warn { "Serializer missing for $kClass, used 'toString()' fallback." }
                    JsonPrimitive(this.toString())
                }
            }
        }
    }
}

/**
 * Generate JSON of a particular class recursively with all default value.
 * List or Map type will have one element exactly.
 */
object JsonGenerator {
    inline fun <reified T> generate(
        json: Json, policy: GenerationPolicy
    ): String {
        val serializer = serializer<T>()
        val element = generateElement(serializer.descriptor, policy)
        return json.encodeToString(JsonElement.Companion.serializer(), element)
    }

    fun generateElement(
        desc: SerialDescriptor,
        policy: GenerationPolicy,
        path: MutableSet<SerialDescriptor> = mutableSetOf()
    ): JsonElement {
        if (desc.isInline) {
            return generateElement(
                desc.getElementDescriptor(0),
                policy,
                path
            )
        }

        if (!path.add(desc)) {
            return JsonNull
        }

        val result = when (desc.kind) {
            StructureKind.CLASS -> {
                buildJsonObject {
                    for (i in 0 until desc.elementsCount) {
                        val name = desc.getElementName(i)
                        val childDesc = desc.getElementDescriptor(i)
                        put(
                            name,
                            generateElement(
                                childDesc,
                                policy,
                                path
                            )
                        )
                    }
                }
            }

            StructureKind.LIST -> {
                generateList(desc, policy.collections) {
                    generateElement(it, policy, path)
                }
            }

            StructureKind.MAP -> {
                generateMap(desc, policy.collections, policy.keys) {
                    generateElement(it, policy, path)
                }
            }

            is PrimitiveKind -> primitiveValue(desc, policy.values)

            else -> JsonNull
        }

        path.remove(desc)
        return result
    }

    fun primitiveValue(
        desc: SerialDescriptor,
        policy: ValuePolicy
    ): JsonPrimitive =
        when (desc.kind) {
            PrimitiveKind.INT -> JsonPrimitive(policy.int())
            PrimitiveKind.LONG -> JsonPrimitive(policy.long())
            PrimitiveKind.STRING -> JsonPrimitive(policy.string())
            PrimitiveKind.BOOLEAN -> JsonPrimitive(policy.boolean())
            PrimitiveKind.FLOAT -> JsonPrimitive(policy.float())
            PrimitiveKind.DOUBLE -> JsonPrimitive(policy.double())
            SerialKind.CONTEXTUAL -> {
                if (desc.serialName == "kotlin.UInt") {
                    JsonPrimitive(policy.uint().toInt())
                } else {
                    // add more if needed
                    JsonPrimitive(1)
                }
            }

            else -> JsonNull
        }

    fun generateList(
        desc: SerialDescriptor,
        policy: CollectionPolicy,
        gen: (SerialDescriptor) -> JsonElement
    ): JsonArray = buildJsonArray {
        when (policy) {
            CollectionPolicy.EMPTY -> Unit
            CollectionPolicy.ONE -> add(gen(desc.getElementDescriptor(0)))
            is CollectionPolicy.MANY ->
                repeat(policy.count) {
                    add(gen(desc.getElementDescriptor(0)))
                }
        }
    }

    fun generateMap(
        desc: SerialDescriptor,
        policy: CollectionPolicy,
        keyPolicy: KeyPolicy,
        gen: (SerialDescriptor) -> JsonElement
    ): JsonObject = buildJsonObject {
        if (policy == CollectionPolicy.EMPTY) return@buildJsonObject

        val keyDesc = desc.getElementDescriptor(0)
        val valueDesc = desc.getElementDescriptor(1)

        val count = when (policy) {
            CollectionPolicy.ONE -> 1
            is CollectionPolicy.MANY -> policy.count
            CollectionPolicy.EMPTY -> 0
        }

        repeat(count) { index ->
            val key = keyPolicy.placeholder(keyDesc, index)
            put(key, gen(valueDesc))
        }
    }

    data class GenerationPolicy(
        val collections: CollectionPolicy = CollectionPolicy.ONE,
        val values: ValuePolicy = ValuePolicy(),
        val keys: KeyPolicy = KeyPolicy()
    )

    class KeyPolicy(
        val int: (Int) -> String = { "0" },
        val uint: (UInt) -> String = { "0" },
        val long: (Int) -> String = { "0" },
        val string: (Int) -> String = { "exampleKey" },
        val boolean: (Int) -> String = { "true" }
    ) {
        fun placeholder(desc: SerialDescriptor, index: Int): String =
            when (desc.kind) {
                PrimitiveKind.INT -> int(index)
                PrimitiveKind.LONG -> long(index)
                PrimitiveKind.STRING -> string(index)
                PrimitiveKind.BOOLEAN -> boolean(index)
                SerialKind.CONTEXTUAL -> {
                    if (desc.serialName == "kotlin.UInt") {
                        uint(index.toUInt())
                    } else {
                        // add more if needed
                        "1"
                    }
                }

                else -> "<${desc.serialName}>"
            }
    }

    class ValuePolicy(
        val int: () -> Int = { 0 },
        val uint: () -> UInt = { 0u },
        val long: () -> Long = { 0L },
        val string: () -> String = { "" },
        val boolean: () -> Boolean = { false },
        val float: () -> Float = { 0f },
        val double: () -> Double = { 0.0 },
    )

    sealed class CollectionPolicy {
        object EMPTY : CollectionPolicy()
        object ONE : CollectionPolicy()
        data class MANY(val count: Int) : CollectionPolicy()
    }
}
