package core.model

import core.model.config.ConfigOutputDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomHarvestPhaseDTO(
    @SerialName("pid") val phaseId: Long = 1,
    @SerialName("et") val expirationTime: Long = 0,
    @SerialName("tl") val timeLeft: Long = 0,
    @SerialName("it") val initTime: Long = 0,
    @SerialName("myst") val mystId: Long = 1,
    @SerialName("o") val rewards: List<ConfigOutputDTO> = emptyList()
)
