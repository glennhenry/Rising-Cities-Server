package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalAttributeThresholdDTO(
    @SerialName("tid") val thresholdId: Int = 0,
    @SerialName("cpai") val configProfAttributeId: Int = 0,
    @SerialName("tt") val type: String = "",
    @SerialName("t") val threshold: Int = 0,
    @SerialName("m") val value: Int = 0,
    @SerialName("cid") val optionalConfigId: Int = 0,
)
