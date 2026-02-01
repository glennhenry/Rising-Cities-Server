package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// inherits [PhaseDTO]
@Serializable
data class EducationPhaseDTO(
    @SerialName("pid") val phaseId: Int = 0,
    @SerialName("et") val expirationTime: Int = 0,
    @SerialName("tl") val timeLeft: Int = 0,
    @SerialName("it") val initTime: Int = 0,
    @SerialName("myst") val mystId: Int = 0,
    @SerialName("a") val educationStep: Int = 0
)
