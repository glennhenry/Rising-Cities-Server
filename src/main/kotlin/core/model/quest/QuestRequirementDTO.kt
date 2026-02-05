package core.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import core.model.constants.QuestSystemTypeConstants

@Serializable
data class QuestRequirementDTO(
    @SerialName("t") val type: String = QuestSystemTypeConstants.TUTORIAL,
    @SerialName("a") val amount: Int = 0,
    @SerialName("id") val configID: UInt = 0u,
) {
    init {
        require(type in QuestSystemTypeConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
