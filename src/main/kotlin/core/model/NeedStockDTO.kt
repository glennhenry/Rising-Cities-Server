package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeedStockDTO(
    @SerialName("cid") val configId: Long = 0,
    @SerialName("a") val amount: Long = 0,
)
