package core.model

import core.model.config.ConfigOutputDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomHarvestPhaseDTO(
    @SerialName("pid") val phaseId: Int = 0,
    @SerialName("et") val expirationTime: Int = 0,
    @SerialName("tl") val timeLeft: Int = 0,
    @SerialName("it") val initTime: Int = 0,
    @SerialName("myst") val mystId: Int = 0,
    @SerialName("o") val rewards: List<ConfigOutputDTO> = emptyList()
)
