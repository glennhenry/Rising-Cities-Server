package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// extends [PhaseDTO]
@Serializable
data class EducationPhaseDTO(
    @SerialName("pid") val phaseId: Long = 0,
    @SerialName("et") val expirationTime: Long = 0,
    @SerialName("tl") val timeLeft: Long = 0,
    @SerialName("it") val initTime: Long = 0,
    @SerialName("myst") val mystId: Long = 0,
    @SerialName("a") val educationStep: Int = 0
)
