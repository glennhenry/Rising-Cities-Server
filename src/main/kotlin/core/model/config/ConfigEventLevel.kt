package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigEventLevel(
    @SerialName("mi") val minimum: Int = 0,
    @SerialName("ma") val maximum: Int = 0,
)
