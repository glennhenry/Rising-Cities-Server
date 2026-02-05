package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigPaymentPackUpsellingDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val category: String = "",
    @SerialName("k") val key: String = "",
    @SerialName("gf") val gfxId: Long = 1,
    @SerialName("fl") val localeId: String = "",
)
