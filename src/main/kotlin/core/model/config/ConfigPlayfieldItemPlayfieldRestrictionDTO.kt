package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldItemPlayfieldRestrictionDTO(
    @SerialName("cpi") val configPlayfieldId: Long = 0,
)
