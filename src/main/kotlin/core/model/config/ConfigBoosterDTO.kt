package core.model.config

import core.model.constants.ServerTagConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigBoosterDTO(
    @SerialName("cid") val id: Long = 1,
    @SerialName("gfx") val gfxId: Long = 1,
    @SerialName("lid") val locaId: Long = 1,
    @SerialName("tag") val tags: List<String> = emptyList(),
    @SerialName("cst") val priceConfigs: List<ConfigOutputDTO> = emptyList(),
) {
    init {
        tags.forEach {
            require(it in ServerTagConstants.ALL) {
                "Invalid constants: $it"
            }
        }
    }
}
