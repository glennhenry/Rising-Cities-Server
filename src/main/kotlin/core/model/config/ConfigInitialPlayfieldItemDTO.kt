package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigInitialPlayfieldItemDTO(
    @SerialName("cpi") val configId: Int = 0,
    @SerialName("x") val xPos: Int = 0,
    @SerialName("y") val yPos: Int = 0
)
