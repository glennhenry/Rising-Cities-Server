package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNewsscreenSlideDTO(
    @SerialName("g") val gfxId: Int = 0,
    @SerialName("o") val orderId: Long = 0,
    @SerialName("l") val locaId: String = "",
    @SerialName("t") val linkType: String = "",
    @SerialName("v") val linkValue: String = "",
)
