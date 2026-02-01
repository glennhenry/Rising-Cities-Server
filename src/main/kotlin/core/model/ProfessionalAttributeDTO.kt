package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionalAttributeDTO(
    @SerialName("cpa") val configId: Int = 0,
    @SerialName("ap") val attributePoints1: Int = 0,
    @SerialName("prof") val professionalID: Int = 0,
)
