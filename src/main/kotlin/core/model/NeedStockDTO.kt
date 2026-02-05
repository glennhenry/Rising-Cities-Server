package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeedStockDTO(
    @SerialName("cid") val configId: Long = 1,
    @SerialName("a") val amount: Long = 0,
)
