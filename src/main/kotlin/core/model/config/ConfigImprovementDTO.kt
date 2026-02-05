package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigImprovementDTO(
    @SerialName("cid") val id: Long = 1,
    @SerialName("gfx") val gfxId: Long = 1,
    @SerialName("lo") val locaId: String = "",
    @SerialName("q") val quality: String = "",
    @SerialName("t") val lifetime: Long? = null,
    @SerialName("c") val renewCost: Int = 0,
    @SerialName("eff") val effects: List<ConfigEffectDTO> = emptyList(),
    @SerialName("tag") val tagIds: List<Long> = emptyList(),
)
