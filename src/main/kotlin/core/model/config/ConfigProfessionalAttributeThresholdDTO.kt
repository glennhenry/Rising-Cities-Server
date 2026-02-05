package core.model.config

import core.model.constants.ServerProfessionalConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalAttributeThresholdDTO(
    @SerialName("tid") val thresholdId: Long = 1,
    @SerialName("cpai") val configProfAttributeId: Long = 1,
    @SerialName("tt") val type: String = ServerProfessionalConstants.ATTRIBUTE_LUCK,
    @SerialName("t") val threshold: Int = 0,
    @SerialName("m") val value: Long = 0,
    @SerialName("cid") val optionalConfigId: Long = 1,
) {
    init {
        require(type in ServerProfessionalConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
