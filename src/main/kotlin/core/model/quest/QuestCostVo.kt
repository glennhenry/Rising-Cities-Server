package core.model.quest

import core.model.constants.QuestSystemRewardTypeConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestCostVo (
    // explicit check of [QuestSystemRewardTypeConstants]
    @SerialName("t") val rewardType: String = QuestSystemRewardTypeConstants.QUEST,
    // explicit amount checking in `QuestFactory.getQuestRewardDto`
    @SerialName("a") val amount: Long = 1,
    @SerialName("id") val rewardConfigID: Long = 1,
) {
    init {
        require(rewardType in QuestSystemRewardTypeConstants.ALL) {
            "Invalid constants: $rewardType"
        }
    }
}
