package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldItemImprovementSlotDTO(
    @SerialName("sid") val id: Long = 0,
    @SerialName("oid") val orderId: Int = 0,
)
