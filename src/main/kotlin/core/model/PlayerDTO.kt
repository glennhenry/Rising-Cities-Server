package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `PlayerDTO.as`
 *
 * most types are still placeholdered
 */
@Serializable
data class PlayerDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("d") val defaultCity: String = "",
    @SerialName("cul") val configUserLevelId: Int = 0,
    @SerialName("ip") val premiumPlayer: Boolean = false,
    @SerialName("n") val playerName: String = "",
    @SerialName("q") val questBooks: String = "",
    @SerialName("i") val inventory: String = "",
    @SerialName("c") val cities: List<String> = emptyList(),
    @SerialName("r") val resources: Map<Int, String> = emptyMap(), // Int: ResourceDTO
    @SerialName("ns") val configNewsscreenList: String = "",
    @SerialName("p") val playerPaymentPackInfo: String = "",
    @SerialName("ef") val enabledFeatures: List<String> = emptyList(),
    @SerialName("ui") val ui: String = "",
)
