package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigOutputDTO(
    @SerialName("t") val type: String = "",
    @SerialName("cid") val configId: Long = 0,
    @SerialName("o") val outputAmount: Long = 0,
    @SerialName("m") val multiplier: Long = 0,
)
