package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldItemImprovementSlotDTO(
    @SerialName("sid") val id: Long = 1,
    @SerialName("oid") val orderId: Long = 1,
)
