package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `ConfigResourceDTO.as`
 */
@RevisitLater("constants")
@Serializable
data class ConfigResourceDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("t") val type: String = "",
    @SerialName("l") val levelId: Long = 0,
    @SerialName("s") val sellable: Boolean = false,
    @SerialName("b") val buyable: Boolean = false,
    @SerialName("g") val giftable: Boolean = false,
    @SerialName("c") val cap: Long = 0,
    @SerialName("es") val resourceEffectIds: List<Long> = emptyList(),
)
