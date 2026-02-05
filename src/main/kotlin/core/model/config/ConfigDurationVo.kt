package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigDurationVo(
    @SerialName("d") val duration: Long = 1,
    @SerialName("tu") val timeUnit: String = "",
)
