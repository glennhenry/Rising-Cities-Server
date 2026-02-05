package core.model.config

import annotation.RevisitLater
import core.model.constants.ServerResConst
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `ConfigResourceDTO.as`
 */
@RevisitLater("constants")
@Serializable
data class ConfigResourceDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("t") val type: String = ServerResConst.RESOURCE_WORKERS,
    @SerialName("l") val levelId: Long = 1,
    @SerialName("s") val sellable: Boolean = false,
    @SerialName("b") val buyable: Boolean = false,
    @SerialName("g") val giftable: Boolean = false,
    @SerialName("c") val cap: Long = 10000,
    @SerialName("es") val resourceEffectIds: List<Long> = emptyList(),
) {
    init {
        require(type in ServerResConst.ALL || type == "") {
            "Invalid constants: $type"
        }
    }
}
