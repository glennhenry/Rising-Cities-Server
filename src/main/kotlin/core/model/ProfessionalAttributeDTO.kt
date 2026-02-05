package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionalAttributeDTO(
    @SerialName("cpa") val configId: Long = 1,
    @SerialName("ap") val attributePoints: Int = 0,
    @SerialName("prof") val professionalId: Long = 1,
)
