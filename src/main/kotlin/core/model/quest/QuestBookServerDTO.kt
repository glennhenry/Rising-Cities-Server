package core.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestBookServerDTO(
    @SerialName("t") val type: String = QuestSystemTypeConstants.TUTORIAL,
    @SerialName("q") val list: List<QuestDTO> = emptyList(),
    @SerialName("h") val history: List<QuestHistoryVo> = emptyList()
) {
    init {
        require(type in QuestSystemTypeConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
