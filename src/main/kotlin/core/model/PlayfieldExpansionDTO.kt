package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayfieldExpansionDTO(
    @SerialName("pid") val id: Long = 1,
    @SerialName("cpe") val configId: Long = 1
)
