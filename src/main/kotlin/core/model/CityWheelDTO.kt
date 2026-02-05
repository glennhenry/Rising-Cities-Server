package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityWheelDTO(
    @SerialName("l") val lottery: List<CityWheelRewardDTO> = emptyList(),
    @SerialName("r") val drawnRewards: List<CityWheelRewardDTO> = emptyList(),
    @SerialName("b") val drawnBuffId: Long = 1
)
