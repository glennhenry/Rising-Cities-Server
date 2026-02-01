package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionalTraitDTO(
    @SerialName("s") val stacks: UInt = 0u,
    @SerialName("cpt") val configId: Int = 0,
    @SerialName("prof") val professionalId: Int = 0,
)
