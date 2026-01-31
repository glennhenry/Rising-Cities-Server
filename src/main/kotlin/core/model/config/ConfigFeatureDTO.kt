package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigFeatureDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("type") val type: String = "",
    @SerialName("rq") val requirements: List<ConfigFeatureRequirementDTO> = emptyList(),
)
