package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigMasteryBonusGroupDTO(
    @SerialName("gid") val groupId: Long = 1,
    @SerialName("sid") val selectionId: Long = 1,
    @SerialName("out") val configOutputs: List<ConfigOutputDTO> = emptyList(),
)
