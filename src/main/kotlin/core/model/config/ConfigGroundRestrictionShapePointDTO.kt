package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigGroundRestrictionShapePointDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("o") val shapePosition: Int = 0,
    @SerialName("x") val x: Int = 0,
    @SerialName("y") val y: Int = 0,
)
