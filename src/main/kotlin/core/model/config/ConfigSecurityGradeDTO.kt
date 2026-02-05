package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigSecurityGradeDTO(
    @SerialName("rx") val rangeX: Int = 0,
    @SerialName("ry") val rangeY: Int = 0,
    @SerialName("v") val value: Int = 0,
    @SerialName("dt") val type: String = "",
    @SerialName("cid") val id: Long = 1,
    @SerialName("o") val orderId: Long = 1,
)
