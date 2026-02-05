package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigGroundRestrictionShapePointDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("o") val shapePosition: Long = 0,
    @SerialName("x") val x: Long = 0,
    @SerialName("y") val y: Long = 0,
)
