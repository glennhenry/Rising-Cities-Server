package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigTagDTO(
    @SerialName("id") val tagId: Long = 1,
    @SerialName("tn") val tagName: String = "",
)
