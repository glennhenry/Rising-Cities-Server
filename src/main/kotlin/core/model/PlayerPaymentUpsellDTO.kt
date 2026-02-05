package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerPaymentUpsellDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val type: String = "",
    @SerialName("st") val startTime: Long = 0,
    @SerialName("d") val duration: Long = 0,
)
