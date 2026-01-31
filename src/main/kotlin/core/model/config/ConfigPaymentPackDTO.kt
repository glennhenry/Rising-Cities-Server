package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPaymentPackDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("k") val key: String = "",
    @SerialName("t") val type: String = "",
    @SerialName("fl") val locaId: Int = 0,
    @SerialName("gf") val gfxId: Int = 0,
    @SerialName("rc") val priceRC: Int? = null,
    @SerialName("r") val resources: List<ConfigOutputDTO> = emptyList(),
    @SerialName("g") val goods: List<ConfigOutputDTO> = emptyList(),
    @SerialName("p") val permissions: List<ConfigOutputDTO> = emptyList(),
    @SerialName("a") val assists: List<ConfigOutputDTO> = emptyList(),
    @SerialName("i") val improvements: List<ConfigOutputDTO>? = null,
    @SerialName("tag") val tagIds: List<Int>? = null,
    @SerialName("up") val upsellPackages: List<ConfigPaymentPackUpsellingDTO> = emptyList(),
)
