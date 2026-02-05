package core.model.quest

import core.model.constants.QuestSystemRewardTypeConstants
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

// extends [QuestCostVo] and implements IQuestRewardDTO
@Serializable
data class QuestRewardDTO(
    @SerialName("t") val rewardType: String = QuestSystemRewardTypeConstants.QUEST,
    @SerialName("a") val amount: Long = 1,
    @SerialName("id") val rewardConfigID: Long = 1,
    @SerialName("d") val willItDrop: Boolean = false,
    @SerialName("m") val isMainReward: Boolean = false,
) {
    init {
        require(rewardType in QuestSystemRewardTypeConstants.ALL || rewardType == "") {
            "Invalid constants: $rewardType"
        }
    }
}
