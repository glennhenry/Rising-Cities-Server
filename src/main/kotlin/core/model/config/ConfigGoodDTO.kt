package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigGoodDTO(
    @SerialName("t") val tagIds: List<Int> = emptyList(),
    @SerialName("eqi") val associatedEventIds: List<Int> = emptyList(),
    @SerialName("id") val configId: Int = 0,
    @SerialName("l") val levelId: Int = 0,
    @SerialName("s") val sellable: Boolean = false,
    @SerialName("p") val produceable: Boolean = false,
    @SerialName("g") val giftable: Boolean = false,
    @SerialName("gfx") val gfxId: Int = 0,
    @SerialName("lo") val localeId: String = "",
)
