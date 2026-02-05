package core.model.config

import core.model.constants.ServerOutputConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// extends [ConfigOutputDTO]
@Serializable
data class ConfigEffectDTO(
    @SerialName("t") val type: String = ServerOutputConstants.GOOD,
    @SerialName("cid") val configId: Long = 1,
    @SerialName("o") val outputAmount: Long = 0,
    @SerialName("m") val multiplier: Long = 0,
    @SerialName("ta") val target: String = "",
    @SerialName("out") val targetOutputList: List<ConfigOutputDTO> = emptyList(),
) {
    init {
        require(type in ServerOutputConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
