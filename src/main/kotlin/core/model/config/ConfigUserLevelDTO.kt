package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigUserLevelDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("l") val level: Int = 0,
    @SerialName("nid") val nextLevelId: Int = 0,
    @SerialName("pid") val previousLevelId: Int = 0,
    @SerialName("xp") val xp: Int = 0,
    @SerialName("axp") val requiredXP: Int = 0,
    @SerialName("qs") val availableQuestSlots: Int = 0,
    @SerialName("o") val levelOutputs: List<ConfigOutputDTO> = emptyList(),
)
