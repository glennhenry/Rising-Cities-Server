package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigEventLevel(
    @SerialName("mi") val minimum: Long = 0,
    @SerialName("ma") val maximum: Long = 0,
)
