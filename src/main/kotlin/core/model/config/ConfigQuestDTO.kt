package core.model.config

import core.model.quest.QuestRequirementDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigQuestDTO(
    @SerialName("et") val timeLeft: Long = 0,
    @SerialName("s") val resumable: Boolean = false,
    @SerialName("cgId") val questGiverGFXid: Long = 0,
    @SerialName("rq") val questRequirements: List<QuestRequirementDTO> = emptyList(),
)
