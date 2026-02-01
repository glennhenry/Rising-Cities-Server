package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MasteryBonusDTO(
    @SerialName("bid") val configBonusId: Long = 0,
    @SerialName("g") val highestUnlockedBonusGroup: Int = 0,
    @SerialName("s") val selectedBonus: Int? = 0,
)
