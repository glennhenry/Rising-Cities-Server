package core.model.config

import core.model.DepartmentRequirementDTO
import core.model.EmergencyRequirementDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigEmergencyDTO(
    @SerialName("l") val lifetime: Long = 0,
    @SerialName("gid") val gfxId: Long = 1,
    @SerialName("lid") val locaId: Long = 1,
    @SerialName("d") val departmentRequirements: List<DepartmentRequirementDTO> = emptyList(),
    @SerialName("er") val emergencyRequirements: List<EmergencyRequirementDTO> = emptyList(),
)
