package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class InventoryDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("c") val configId: Int = 0,
    @SerialName("b") val bags: List<InventoryItemBagDTO>? = null,
)
