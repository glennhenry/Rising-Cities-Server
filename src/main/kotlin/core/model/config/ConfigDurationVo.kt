package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigDurationVo(
    @SerialName("d") val duration: Int = 0,
    @SerialName("tu") val timeUnit: String = "",
)
