package core.model.config

import core.model.constants.ServerTagConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigTagDTO(
    @SerialName("id") val tagId: Long = 1,
    @SerialName("tn") val tagName: String = ServerTagConstants.SHOP,
) {
    init {
        require(tagName in ServerTagConstants.ALL) {
            "Invalid constants: $tagName"
        }
    }
}
