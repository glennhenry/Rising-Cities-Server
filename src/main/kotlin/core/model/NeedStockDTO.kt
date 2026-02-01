package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeedStockDTO(
    @SerialName("cid") val configId: Int = 0,
    @SerialName("a") val amount: Int = 0,
)
