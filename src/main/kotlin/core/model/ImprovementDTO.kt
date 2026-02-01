package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// inherits PhaseDTO
@Serializable
data class ImprovementDTO(
    @SerialName("pid") val phaseId: Int = 0,
    @SerialName("et") val expirationTime: Int = 0,
    @SerialName("tl") val timeLeft: Int = 0,
    @SerialName("it") val initTime: Int = 0,
    @SerialName("myst") val mystId: Int = 0,
    @SerialName("cid") val configId: Int = 0,
    @SerialName("sid") val slotId: Int = 0,
    @SerialName("bid") val buildingId: Int = 0,
)
