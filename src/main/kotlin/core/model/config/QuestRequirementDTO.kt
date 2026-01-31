package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestRequirementDTO(
    @SerialName("t") val type: String = "",
    @SerialName("a") val amount: Int = 0,
    @SerialName("id") val configID: UInt = 0u,
)
