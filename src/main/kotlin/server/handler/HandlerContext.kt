package server.handler

import server.core.network.Connection
import server.messaging.socket.SocketMessage

/**
 * Encapsulate objects and data needed by handlers to handle message.
 *
 * @property userId The player in-game unique identifier.
 * @property message High-level representation of the socket message.
 * @param T Concrete implementation of [SocketMessage] interface.
 */
interface HandlerContext<T : SocketMessage> {
    var userId: Long
    val message: T

    /**
     * Send the client [raw] bytes.
     *
     * Serialization is caller responsibility. This can be done
     * by calling the appropriate serializer utility.
     */
    suspend fun sendRaw(raw: ByteArray, logOutput: Boolean = true, logFull: Boolean = false)

    /**
     * To update the userId for this connection (usually goes through [Connection.updateUserId]).
     */
    fun updateUserId(userId: Long)
}
