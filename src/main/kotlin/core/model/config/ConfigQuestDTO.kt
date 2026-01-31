package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigQuestDTO(
    @SerialName("et") val timeLeft: Int = 0,
    @SerialName("s") val resumable: Boolean = false,
    @SerialName("cgId") val questGiverGFXid: Int = 0,
    @SerialName("rq") val questRequirements: List<QuestRequirementDTO> = emptyList(),
)
