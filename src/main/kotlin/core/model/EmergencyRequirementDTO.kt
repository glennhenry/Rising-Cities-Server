package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmergencyRequirementDTO(
    @SerialName("pr") val configProfSpecializationId: Int = 0,
    @SerialName("nr") val slotNumber: Int = 0,
)
