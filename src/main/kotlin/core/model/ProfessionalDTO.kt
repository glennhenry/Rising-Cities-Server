package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionalDTO(
    @SerialName("pid") val id: Int = 0,
    @SerialName("bid") val buildingId: Int = 0,
    @SerialName("e") val experience: UInt = 0u,
    @SerialName("l") val lifetime: Int = 0,
    @SerialName("csi") val configSpecializationId: Int = 0,
    @SerialName("gfx") val gfxId: String = "",
    @SerialName("g") val gender: Int = 0,
    @SerialName("n") val name: Int = 0,
    @SerialName("sn") val surname: Int = 0,
    @SerialName("exc") val extendedCount: Int = 0,
    @SerialName("a") val attributes: List<ProfessionalAttributeDTO> = emptyList(),
    @SerialName("ssi") val possibleSpecialisationIdsByLevelUp: List<Int> = emptyList(),
    @SerialName("t") val traits: List<ProfessionalTraitDTO?> = emptyList(),
    @SerialName("lu") val canLevelUp: Boolean = false,
    @SerialName("usp") val unspentSkillPoints: Int = 0,
)
