package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigBoosterDTO(
    @SerialName("cid") val id: Int = 0,
    @SerialName("gfx") val gfxId: Int = 0,
    @SerialName("lid") val locaId: Int = 0,
    @SerialName("tag") val tags: List<String> = emptyList(),
    @SerialName("cst") val priceConfigs: List<ConfigOutputDTO> = emptyList(),
)
