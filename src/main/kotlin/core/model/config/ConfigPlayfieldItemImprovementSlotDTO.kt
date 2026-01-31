package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldItemImprovementSlotDTO(
    @SerialName("sid") val id: Int = 0,
    @SerialName("oid") val orderId: Int = 0,
)
