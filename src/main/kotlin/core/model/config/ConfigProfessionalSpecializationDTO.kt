package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalSpecializationDTO(
    @SerialName("cpsi") val id: Long = 1,
    @SerialName("dt") val departmentTagId: Long = 1,
    @SerialName("r") val rank: Int = 0,
    @SerialName("v") val slotMaxValue: Int = 0,
    @SerialName("gfx") val gfxId: Long = 1,
    @SerialName("lo") val locaId: String = "",
)
