package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DecorationDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("c") val configId: Int = 0,
    @SerialName("x") val posX: Int = 0,
    @SerialName("y") val posY: Int = 0,
    @SerialName("cr") val cr: Int = 0,
    @SerialName("lu") val lastUpdatedTimeStamp: Int = 0,
)
