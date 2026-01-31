package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigNeedDTO(
    @SerialName("x") val buffRangeX: Int = 0,
    @SerialName("y") val buffRangeY: Int = 0,
    @SerialName("n") val requiredGoods: List<ConfigNeedStackDTO> = emptyList(),
)
