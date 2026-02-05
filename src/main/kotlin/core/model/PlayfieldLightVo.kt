package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayfieldLightVo(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val configId: Long = 1
)
