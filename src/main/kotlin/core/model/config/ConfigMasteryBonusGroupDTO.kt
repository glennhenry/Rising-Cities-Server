package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigMasteryBonusGroupDTO(
    @SerialName("gid") val groupId: Int = 0,
    @SerialName("sid") val selectionId: Int = 0,
    @SerialName("out") val configOutputs: List<ConfigOutputDTO> = emptyList(),
)
