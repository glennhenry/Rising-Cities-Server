package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class InventoryItemBagDTO(
    @SerialName("t") val type: String = "",
    @SerialName("c") val configId: Int = 0,
    @SerialName("s") val slots: Int = 0,
    @SerialName("i") val items: List<InventoryItemDTO> = emptyList(),
)
