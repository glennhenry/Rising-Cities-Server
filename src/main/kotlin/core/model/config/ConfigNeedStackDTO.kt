package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNeedStackDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("s") val maxStack: Long = 0,
    @SerialName("o") val configOutput: ConfigOutputDTO = ConfigOutputDTO(),
)
