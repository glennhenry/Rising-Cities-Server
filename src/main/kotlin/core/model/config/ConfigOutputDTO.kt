package core.model.config

import core.model.constants.ServerOutputConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigOutputDTO(
    @SerialName("t") val type: String = ServerOutputConstants.GOOD,
    @SerialName("cid") val configId: Long = 1,
    @SerialName("o") val outputAmount: Long = 0,
    @SerialName("m") val multiplier: Long = 0,
) {
    init {
        require(type in ServerOutputConstants.ALL || type == "") {
            "Invalid constants: $type"
        }
    }
}
