package core.model

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class DepartmentRequirementDTO(
    @SerialName("e") val emergencyCode: Int = 0,
    @SerialName("d") val departmentType: String = "",
    @SerialName("m") val mainDept: Boolean = false
)
