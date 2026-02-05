package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigGroundRestrictionDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("pid") val playfieldId: Long = 1,
    @SerialName("bw") val whiteList: Boolean = false,
    @SerialName("gt") val groundType: String = "",
    @SerialName("shape") val configGroundRestrictionShapes: List<ConfigGroundRestrictionShapeDTO> = emptyList(),
    @SerialName("gid") val configTagIds: List<Long> = emptyList(),
)
