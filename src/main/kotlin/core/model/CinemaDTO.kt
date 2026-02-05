package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CinemaDTO(
    @SerialName("v") val viewsToday: UInt = 0u,
    @SerialName("t") val resetTimeStamp: Long = 0
)
