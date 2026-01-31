package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldTypeDTO(
    @SerialName("id") val id: Int = 0,
)
