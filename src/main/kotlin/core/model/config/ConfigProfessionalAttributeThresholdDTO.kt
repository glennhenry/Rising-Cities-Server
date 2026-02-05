package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigProfessionalAttributeThresholdDTO(
    @SerialName("tid") val thresholdId: Long = 1,
    @SerialName("cpai") val configProfAttributeId: Long = 1,
    @SerialName("tt") val type: String = "",
    @SerialName("t") val threshold: Int = 0,
    @SerialName("m") val value: Long = 0,
    @SerialName("cid") val optionalConfigId: Long = 1,
)
