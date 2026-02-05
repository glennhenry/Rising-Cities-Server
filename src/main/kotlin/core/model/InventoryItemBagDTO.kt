package core.model

import annotation.RevisitLater
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@RevisitLater("constants")
@Serializable
data class InventoryItemBagDTO(
    @SerialName("t") val type: String = "",
    @SerialName("c") val configId: Long = 1,
    @SerialName("s") val slots: Int = 0,
    @SerialName("i") val items: List<InventoryItemDTO> = emptyList(),
)
