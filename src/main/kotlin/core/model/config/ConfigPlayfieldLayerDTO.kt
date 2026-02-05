package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldLayerDTO(
    @SerialName("id") val id: Long = 1,
)
