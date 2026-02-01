package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigCinemaDTO(
    @SerialName("mv") val maxViewsPerDay: UInt = 0u,
    @SerialName("mt") val maxResetLifeTime: Long = 0,
)
