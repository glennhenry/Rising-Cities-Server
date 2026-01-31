package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// inherits [ConfigOutputDTO]
@Serializable
data class ConfigEffectDTO(
    @SerialName("t") val type: String = "",
    @SerialName("cid") val configId: Int = 0,
    @SerialName("o") val outputAmount: Int = 0,
    @SerialName("m") val multiplier: Int = 0,
    @SerialName("ta") val target: Int = 0,
    @SerialName("out") val targetOutputList: List<ConfigOutputDTO> = emptyList(),
)
