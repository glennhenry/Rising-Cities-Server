package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigGroundRestrictionShapeDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("p") val shapePoints: List<ConfigGroundRestrictionShapePointDTO> = emptyList(),
)
