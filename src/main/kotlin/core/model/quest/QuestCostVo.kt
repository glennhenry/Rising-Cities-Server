package core.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestCostVo (
    // explicit check of [QuestSystemRewardTypeConstants]
    @SerialName("t") val rewardType: String = QuestSystemRewardTypeConstants.QUEST,
    // explicit amount checking in `QuestFactory.getQuestRewardDto`
    @SerialName("a") val amount: Int = 1,
    @SerialName("id") val rewardConfigID: Int = 1,
) {
    init {
        require(rewardType in QuestSystemRewardTypeConstants.ALL) {
            "Invalid constants: $rewardType"
        }
    }
}
