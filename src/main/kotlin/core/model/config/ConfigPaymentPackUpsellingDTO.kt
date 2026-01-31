package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPaymentPackUpsellingDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("c") val category: String = "",
    @SerialName("k") val key: String = "",
    @SerialName("gf") val gfxId: Int = 0,
    @SerialName("fl") val localeId: String = "",
)
