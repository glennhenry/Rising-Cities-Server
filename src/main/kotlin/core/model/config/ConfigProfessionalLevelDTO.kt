package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalLevelDTO(
    @SerialName("pli") val id: Long = 1,
    @SerialName("xp") val xpThreshold: UInt = 0u,
    @SerialName("sp") val skillpointGain: UInt = 0u,
)
