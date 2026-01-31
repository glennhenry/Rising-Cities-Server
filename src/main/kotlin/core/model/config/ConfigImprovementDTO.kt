package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigImprovementDTO(
    @SerialName("cid") val id: Int = 0,
    @SerialName("gfx") val gfxId: Int = 0,
    @SerialName("lo") val locaId: String = "",
    @SerialName("q") val quality: String = "",
    @SerialName("t") val lifetime: Int? = null,
    @SerialName("c") val renewCost: Int = 0,
    @SerialName("eff") val effects: List<ConfigEffectDTO> = emptyList(),
    @SerialName("tag") val tagIds: List<Int> = emptyList(),
)
