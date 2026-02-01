package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigFeatureRequirementDTO(
    @SerialName("eid") val correspondingConfigId: Long = 0,
    @SerialName("t") val type: String = "",
)
