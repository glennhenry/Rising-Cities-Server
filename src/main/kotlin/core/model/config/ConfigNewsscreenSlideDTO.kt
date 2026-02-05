package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNewsscreenSlideDTO(
    @SerialName("g") val gfxId: Long = 1,
    @SerialName("o") val orderId: Long = 1,
    @SerialName("l") val locaId: String = "",
    @SerialName("t") val linkType: String = "",
    @SerialName("v") val linkValue: String = "",
)
