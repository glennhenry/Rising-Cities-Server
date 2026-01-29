package server.messaging.socket

import kotlinx.serialization.Serializable
import server.messaging.socket.domain.LoginRequest
import server.messaging.socket.domain.LoginResponse

/**
 * Root representation for high-level RC messages.
 *
 * Implementations represent **typed messages**, where each concrete
 * message corresponds to a specific protocol header.
 *
 * Typical conventions:
 * - Message classes are named `XRequest` / `XResponse`, where `X` describes
 *   the intent or feature of the message. E.g., [LoginRequest] and [LoginResponse]
 * - `Request` messages are sent by the client; `Response` messages are sent
 *   by the server.
 * - `Request` messages may inherit this class, while `Response` message should
 *   inherit the [RCResponse].
 * - Both request and response types are usually annotated with `@Serializable`
 *   to enable JSON-based serialization.
 *
 * The message [header] serves as the protocol identifier and is exposed
 * through [SocketMessage.type] for handler dispatch.
 */
interface RCMessage : SocketMessage {
    /**
     * Protocol header identifying the message type.
     */
    val header: String

    /**
     * Returns the logical message type, mapped directly to [header].
     */
    override fun type(): String = header
}

interface RCResponse {
    /**
     * Protocol header identifying the message type.
     */
    val header: String
}

/**
 * Represent an unknown (unidentified header) or any unimplemented
 * RC messages.
 */
@Serializable
data class UnknownRCMessage(
    override val header: String,
    val jsonPayload: String
) : RCMessage {
    override fun toString(): String = "UnknownRCMessage(json=$jsonPayload)"
}
