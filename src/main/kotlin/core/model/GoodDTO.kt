package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoodDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("c") val configId: Int = 0,
    @SerialName("a") val amount: Int = 0
)
