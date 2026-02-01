package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigBoosterDTO(
    @SerialName("cid") val id: Long = 0,
    @SerialName("gfx") val gfxId: Long = 0,
    @SerialName("lid") val locaId: Long = 0,
    @SerialName("tag") val tags: List<String> = emptyList(),
    @SerialName("cst") val priceConfigs: List<ConfigOutputDTO> = emptyList(),
)
