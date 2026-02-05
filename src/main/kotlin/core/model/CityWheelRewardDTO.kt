package core.model

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// extends ConfigOutputDTO
@RevisitLater("constants")
@Serializable
data class CityWheelRewardDTO(
    @SerialName("t") val type: String = "",
    @SerialName("cid") val configId: Long = 1,
    @SerialName("o") val outputAmount: Long = 0,
    @SerialName("m") val multiplier: Long = 0,
    @SerialName("rt") val rewardTypeTagId: Long = 1,
    @SerialName("r") val drawnReward: Boolean = false,
)
