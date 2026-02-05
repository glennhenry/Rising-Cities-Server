package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigInventoryDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("b") val configInventoryBags: List<ConfigInventoryBagDTO>? = null,
)
