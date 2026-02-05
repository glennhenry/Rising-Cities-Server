package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionalDTO(
    @SerialName("pid") val id: Long = 1,
    @SerialName("bid") val buildingId: Long = 1,
    @SerialName("e") val experience: UInt = 0u,
    @SerialName("l") val lifetime: Long = 0,
    @SerialName("csi") val configSpecializationId: Long = 1,
    @SerialName("gfx") val gfxId: String = "",
    @SerialName("g") val gender: Int = 0,
    @SerialName("n") val name: Int = 0,
    @SerialName("sn") val surname: Int = 0,
    @SerialName("exc") val extendedCount: Int = 0,
    @SerialName("a") val attributes: List<ProfessionalAttributeDTO> = emptyList(),
    @SerialName("ssi") val possibleSpecialisationIdsByLevelUp: List<Long> = emptyList(),
    @SerialName("t") val traits: List<ProfessionalTraitDTO?> = emptyList(),
    @SerialName("lu") val canLevelUp: Boolean = false,
    @SerialName("usp") val unspentSkillPoints: Int = 0,
)
