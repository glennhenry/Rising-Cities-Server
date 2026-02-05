package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalTraitDTO(
    @SerialName("v") val value: Long = 0,
    @SerialName("cpt") val id: Long = 1,
    @SerialName("lo") val localeid: Long = 1,
    @SerialName("gfx") val gfxid: Long = 1,
)
