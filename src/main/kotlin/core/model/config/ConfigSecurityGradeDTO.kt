package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigSecurityGradeDTO(
    @SerialName("rx") val rangeX: Int = 0,
    @SerialName("ry") val rangeY: Int = 0,
    @SerialName("v") val value: Int = 0,
    @SerialName("dt") val type: String = "",
    @SerialName("cid") val id: Int = 0,
    @SerialName("o") val orderId: Int = 0,
)
