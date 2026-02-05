package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigFeatureDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("type") val type: String = "",
    @SerialName("rq") val requirements: List<ConfigFeatureRequirementDTO> = emptyList(),
)
