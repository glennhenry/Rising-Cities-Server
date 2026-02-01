package core.model.quest

import core.model.config.ConfigEventDTO
import core.model.config.ConfigQuestDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestDTO(
    @SerialName("c") val config: ConfigQuestDTO = ConfigQuestDTO(),
    @SerialName("v") val viewCount: UInt = 0u,
    @SerialName("o") val eventConfig: ConfigEventDTO? = null,
    @SerialName("sid") val slotID: UInt = 0u,
    @SerialName("l") val lastUpdated: Long = 0,
    @SerialName("rw") val rewardList: List<QuestCostVo?> = emptyList()
)
