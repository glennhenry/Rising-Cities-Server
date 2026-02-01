package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalTraitDTO(
    @SerialName("v") val value: Long = 0,
    @SerialName("cpt") val id: Long = 0,
    @SerialName("lo") val localeid: Int = 0,
    @SerialName("gfx") val gfxid: Int = 0,
)
