package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `ConfigResourceDTO.as`
 */
@Serializable
data class ConfigResourceDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("t") val type: String = "",
    @SerialName("l") val levelId: Int = 0,
    @SerialName("s") val sellable: Boolean = false,
    @SerialName("b") val buyable: Boolean = false,
    @SerialName("g") val giftable: Boolean = false,
    @SerialName("c") val cap: Int = 0,
    @SerialName("es") val resourceEffectIds: List<Int> = emptyList(),
)
