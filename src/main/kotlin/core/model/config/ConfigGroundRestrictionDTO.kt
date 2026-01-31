package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigGroundRestrictionDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("pid") val playfieldId: Int = 0,
    @SerialName("bw") val whiteList: Boolean = false,
    @SerialName("gt") val groundType: String = "",
    @SerialName("shape") val configGroundRestrictionShapes: List<ConfigGroundRestrictionShapeDTO> = emptyList(),
    @SerialName("gid") val configTagIds: List<Int> = emptyList(),
)
