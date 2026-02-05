package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigMasteryBonusDTO(
    @SerialName("bid") val id: Long = 1,
    @SerialName("bg") val buffs: List<ConfigMasteryBonusGroupDTO> = emptyList(),
)
