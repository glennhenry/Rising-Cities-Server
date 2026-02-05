package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MasteryChallengeDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("v") val currentProgress: Int = 0
)
