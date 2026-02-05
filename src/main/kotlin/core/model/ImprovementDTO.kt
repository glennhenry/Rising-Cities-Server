package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// extends PhaseDTO
@Serializable
data class ImprovementDTO(
    @SerialName("pid") val phaseId: Long = 1,
    @SerialName("et") val expirationTime: Long = 0,
    @SerialName("tl") val timeLeft: Long = 0,
    @SerialName("it") val initTime: Long = 0,
    @SerialName("myst") val mystId: Long = 1,
    @SerialName("cid") val configId: Long = 1,
    @SerialName("sid") val slotId: Long = 1,
    @SerialName("bid") val buildingId: Long = 1,
)
