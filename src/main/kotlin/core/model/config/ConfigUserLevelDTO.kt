package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigUserLevelDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("l") val level: Long = 0,
    @SerialName("nid") val nextLevelId: Long = 0,
    @SerialName("pid") val previousLevelId: Long = 0,
    @SerialName("xp") val xp: Long = 0,
    @SerialName("axp") val requiredXP: Long = 0,
    @SerialName("qs") val availableQuestSlots: Int = 0,
    @SerialName("o") val levelOutputs: List<ConfigOutputDTO> = emptyList(),
)
