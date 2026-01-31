package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigOutputDTO(
    @SerialName("t") val type: String = "",
    @SerialName("cid") val configId: Int = 0,
    @SerialName("o") val outputAmount: Int = 0,
    @SerialName("m") val multiplier: Int = 0,
)
