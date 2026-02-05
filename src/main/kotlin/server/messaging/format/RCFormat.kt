package server.messaging.format

import annotation.Untested
import server.messaging.ClientMessage
import server.messaging.socket.EmptyRCMessage
import server.messaging.socket.RCResponse
import server.messaging.socket.SocketMessage
import server.messaging.socket.UnknownRCMessage
import server.messaging.socket.domain.LoginRequest
import server.messaging.socket.domain.UpdateClientUIDataRequest
import utils.JSON
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Intermediate type for RC message.
 *
 * Since the RC protocol is simple framing, the "decoding" part is
 * just splitting the bytes between the header and the payload.
 */
data class RCFrame(
    val header: String,
    val jsonPayload: String,
)

/**
 * [MessageFormat] representation of the RC protocol.
 */
@Untested("verify and tryDecode")
class RCFormat : MessageFormat<RCFrame> {
    override val name: String = "RC Format"

    override fun verify(data: ByteArray): Boolean {
        // Need at least lengths
        if (data.size < 6) return false

        val buffer = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN)

        val payloadLength = buffer.int
        val headerLength = buffer.short.toInt() and 0xFFFF

        // Sanity checks
        if (payloadLength < 0) return false
        if (headerLength <= 0) return false

        val expectedTotalSize = 4 + 2 + headerLength + payloadLength
        if (data.size < expectedTotalSize) return false

        // Header bounds check
        val headerStart = 6
        val headerEnd = headerStart + headerLength
        if (headerEnd > data.size) return false

        // Payload bounds check
        val payloadStart = headerEnd
        val payloadEnd = payloadStart + payloadLength
        if (payloadEnd > data.size) return false

        // Quick JSON sanity check
        val firstPayloadByte = data[payloadStart].toInt().toChar()
        val lastPayloadByte = data[payloadEnd - 1].toInt().toChar()

        return !(firstPayloadByte != '{' || lastPayloadByte != '}')
    }

    /**
     * As of now, never returns [DecodeResult.Failure]. Invalid message
     * should fail fast in [verify].
     */
    override fun tryDecode(data: ByteArray): DecodeResult<RCFrame> {
        val buffer = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN)

        val payloadLength = buffer.int
        val headerLength = buffer.short.toInt()

        val headerBytes = ByteArray(headerLength)
        buffer.get(headerBytes)

        val payloadBytes = ByteArray(payloadLength)
        buffer.get(payloadBytes)

        return DecodeResult.Success(
            RCFrame(
                header = headerBytes.toString(Charsets.UTF_8),
                jsonPayload = payloadBytes.toString(Charsets.UTF_8)
            )
        )
    }

    /**
     * Convert each header into the corresponding typed message class.
     */
    override fun materialize(decoded: RCFrame): SocketMessage {
        val message: SocketMessage = when (decoded.header) {
            ClientMessage.LOGIN -> {
                val json = JSON.decode<LoginRequest>(decoded.jsonPayload)
                LoginRequest(json.uid, json.ses)
            }

            ClientMessage.SLAYER_INVITE_REQUEST_FRIENDLIST -> {
                EmptyRCMessage(decoded.header, decoded.jsonPayload)
            }

            ClientMessage.UPDATE_CLIENT_UI_DATA -> {
                val json = JSON.decode<UpdateClientUIDataRequest>(decoded.jsonPayload)
                UpdateClientUIDataRequest(json.dat)
            }

            else -> {
                UnknownRCMessage(decoded.header, decoded.jsonPayload)
            }
        }
        return message
    }
}

/**
 * Serializer for RC format message.
 */
@Untested
object RCSerializer {
    fun serialize(input: RCResponse): ByteArray {
        val payload = JSON.encode(input)
        val headerBytes = input.header.toByteArray(Charsets.UTF_8)
        val payloadBytes = payload.toByteArray(Charsets.UTF_8)

        val buffer = ByteBuffer.allocate(
            4 + 2 + headerBytes.size + payloadBytes.size
        ).order(ByteOrder.BIG_ENDIAN)

        buffer.putInt(payloadBytes.size)
        buffer.putShort(headerBytes.size.toShort())
        buffer.put(headerBytes)
        buffer.put(payloadBytes)

        return buffer.array()
    }

    /**
     * Serialize an already encoded payload.
     *
     * This function merely complete the protocol (i.e., writing header/payload length).
     */
    fun serializeEncoded(header: String, jsonPayload: String): ByteArray {
        val headerBytes = header.toByteArray(Charsets.UTF_8)
        val payloadBytes = jsonPayload.toByteArray(Charsets.UTF_8)

        val buffer = ByteBuffer.allocate(
            4 + 2 + headerBytes.size + payloadBytes.size
        ).order(ByteOrder.BIG_ENDIAN)

        buffer.putInt(payloadBytes.size)
        buffer.putShort(headerBytes.size.toShort())
        buffer.put(headerBytes)
        buffer.put(payloadBytes)

        return buffer.array()
    }
}
