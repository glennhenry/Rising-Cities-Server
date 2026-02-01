package core.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import annotation.RevisitLater

@RevisitLater("constants")
@Serializable
data class QuestRequirementDTO(
    @SerialName("t") val type: String = "",
    @SerialName("a") val amount: Int = 0,
    @SerialName("id") val configID: UInt = 0u,
)