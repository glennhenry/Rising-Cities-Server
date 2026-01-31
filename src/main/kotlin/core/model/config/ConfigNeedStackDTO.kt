package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNeedStackDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("s") val maxStack: Int = 0,
    @SerialName("o") val configOutput: ConfigOutputDTO = ConfigOutputDTO(),
)
