package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNeedRequireDTO(
    @SerialName("nid") val requiredConfigBuildingIds: List<Int> = emptyList(),
    @SerialName("a") val configOutputList: List<ConfigOutputDTO> = emptyList(),
)
