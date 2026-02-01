package core.model.quest

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

// inherits [QuestCostVo] and implements IQuestRewardDTO
@Serializable
data class QuestRewardDTO(
    @SerialName("t") val rewardType: String = QuestSystemRewardTypeConstants.QUEST,
    @SerialName("a") val amount: Int = 1,
    @SerialName("id") val rewardConfigID: Int = 1,
    @SerialName("d") val willItDrop: Boolean = false,
    @SerialName("m") val isMainReward: Boolean = false,
) {
    init {
        require(rewardType in QuestSystemRewardTypeConstants.ALL) {
            "Invalid constants: $rewardType"
        }
    }
}
