package core.model

import annotation.RevisitLater
import core.model.constants.ServerTagConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// extends ConfigOutputDTO
@Serializable
data class CityWheelRewardDTO(
    @SerialName("t") val type: String = ServerTagConstants.INSTANT_FINISH,
    @SerialName("cid") val configId: Long = 1,
    @SerialName("o") val outputAmount: Long = 0,
    @SerialName("m") val multiplier: Long = 0,
    @SerialName("rt") val rewardTypeTagId: Long = 1,
    @SerialName("r") val drawnReward: Boolean = false,
) {
    init {
        require(type in ServerTagConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
