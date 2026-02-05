package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerPaymentPackDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("pd") val purchaseDate: Long = 0,
    @SerialName("it") val initTime: Long = 0,
    @SerialName("u") val used: Boolean = false,
    @SerialName("sl") val showLayer: Boolean = false,
)
