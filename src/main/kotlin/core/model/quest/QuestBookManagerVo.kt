package core.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestBookManagerVo(
    @SerialName("qb") val questBookList: List<QuestBookServerDTO> = emptyList()
)
