package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNewsscreenListDTO(
    @SerialName("s") val configNewsscreenSlideList: List<ConfigNewsscreenSlideDTO> = emptyList(),
)
