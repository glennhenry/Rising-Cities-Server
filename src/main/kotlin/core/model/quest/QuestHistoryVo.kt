package core.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestHistoryVo(
    @SerialName("c") val category: String = "",
    @SerialName("s") val finishCount: Int = 0,
)
