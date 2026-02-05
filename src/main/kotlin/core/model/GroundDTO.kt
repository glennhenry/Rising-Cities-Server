package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GroundDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val configId: Long = 1,
    @SerialName("x") val posX: Long = 1,
    @SerialName("y") val posY: Long = 1,
    @SerialName("cr") val created: Long = 1,
    @SerialName("a") val active: Boolean = false
)
