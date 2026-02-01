package core.model

import core.model.config.ConfigNewsscreenListDTO
import core.model.quest.QuestBookManagerVo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `PlayerDTO.as`
 */
@Serializable
data class PlayerDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("d") val defaultCity: CityDTO = CityDTO(),
    @SerialName("cul") val configUserLevelId: Long = 0,
    @SerialName("ip") val premiumPlayer: Boolean = false,
    @SerialName("n") val playerName: String = "",
    @SerialName("q") val questBooks: QuestBookManagerVo = QuestBookManagerVo(),
    @SerialName("i") val inventory: InventoryDTO = InventoryDTO(),
    @SerialName("c") val cities: List<CityDTO> = emptyList(),
    @SerialName("r") val resources: Map<Long, ResourceDTO> = emptyMap(),
    @SerialName("ns") val configNewsscreenList: ConfigNewsscreenListDTO? = null,
    @SerialName("p") val playerPaymentPackInfo: PlayerPaymentDTO = PlayerPaymentDTO(),
    @SerialName("ef") val enabledFeatures: List<String> = emptyList(),
    @SerialName("ui") val ui: ClientUIDataDTO? = null,
)
