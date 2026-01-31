package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigFeatureRequirementDTO(
    @SerialName("eid") val correspondingConfigId: Int = 0,
    @SerialName("t") val type: String = "",
)
