package core.model.config

import core.model.constants.ServerRestrictionConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigGroundRestrictionDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("pid") val playfieldId: Long = 1,
    @SerialName("bw") val whiteList: Boolean = false,
    @SerialName("gt") val groundType: String = ServerRestrictionConstants.FARMLAND,
    @SerialName("shape") val configGroundRestrictionShapes: List<ConfigGroundRestrictionShapeDTO> = emptyList(),
    @SerialName("gid") val configTagIds: List<Long> = emptyList(),
) {
    init {
        require(groundType in ServerRestrictionConstants.ALL || groundType == "") {
            "Invalid constants: $groundType"
        }
    }
}
