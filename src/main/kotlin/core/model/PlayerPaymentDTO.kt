package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerPaymentDTO(
    @SerialName("pp") val purchasedPaymentPacks: List<PlayerPaymentPackDTO> = emptyList(),
    @SerialName("up") val upsellPaymentPack: PlayerPaymentUpsellDTO? = null,
)
