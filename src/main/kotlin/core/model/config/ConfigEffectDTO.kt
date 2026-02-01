package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
// extends [ConfigOutputDTO]
@Serializable
data class ConfigEffectDTO(
    @SerialName("t") val type: String = "",
    @SerialName("cid") val configId: Long = 0,
    @SerialName("o") val outputAmount: Long = 0,
    @SerialName("m") val multiplier: Long = 0,
    @SerialName("ta") val target: String = "",
    @SerialName("out") val targetOutputList: List<ConfigOutputDTO> = emptyList(),
)
