package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigPaymentPackDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("k") val key: String = "",
    @SerialName("t") val type: String = "",
    @SerialName("fl") val locaId: Long = 1,
    @SerialName("gf") val gfxId: Long = 1,
    @SerialName("rc") val priceRC: Long? = null,
    @SerialName("r") val resources: List<ConfigOutputDTO> = emptyList(),
    @SerialName("g") val goods: List<ConfigOutputDTO> = emptyList(),
    @SerialName("p") val permissions: List<ConfigOutputDTO> = emptyList(),
    @SerialName("a") val assists: List<ConfigOutputDTO> = emptyList(),
    @SerialName("i") val improvements: List<ConfigOutputDTO>? = null,
    @SerialName("tag") val tagIds: List<Long>? = null,
    @SerialName("up") val upsellPackages: List<ConfigPaymentPackUpsellingDTO> = emptyList(),
)
