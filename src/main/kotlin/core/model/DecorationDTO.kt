package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DecorationDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val configId: Long = 1,
    @SerialName("x") val posX: Long = 0,
    @SerialName("y") val posY: Long = 0,
    @SerialName("cr") val cr: Long = 0,
    @SerialName("lu") val lastUpdatedTimeStamp: Long = 0,
)
