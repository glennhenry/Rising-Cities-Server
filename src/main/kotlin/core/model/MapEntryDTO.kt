package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapEntryDTO(
    @SerialName("k") val key: String = "",
    @SerialName("v") val value: String = "",
)