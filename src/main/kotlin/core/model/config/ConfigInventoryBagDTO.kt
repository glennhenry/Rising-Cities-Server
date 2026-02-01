package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigInventoryBagDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("is") val initialSlots: Int = 0,
    @SerialName("ms") val maxSlots: Int = 0,
    @SerialName("pm") val priceModifier: Long = -1,
)
