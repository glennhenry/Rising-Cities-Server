package core.model

import core.data.AdminData
import core.model.config.ConfigNewsscreenListDTO
import core.model.quest.QuestBookManagerVo
import data.collection.PlayerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `PlayerDTO.as`
 */
@Serializable
data class PlayerDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("d") val defaultCity: CityDTO = CityDTO(),
    @SerialName("cul") val configUserLevelId: Long = 1,
    @SerialName("ip") val premiumPlayer: Boolean = false,
    @SerialName("n") val playerName: String = "",
    @SerialName("q") val questBooks: QuestBookManagerVo = QuestBookManagerVo(),
    @SerialName("i") val inventory: InventoryDTO = InventoryDTO(),
    @SerialName("c") val cities: List<CityDTO> = emptyList(),
    /**
     * key is Long in client side, be sure to convert
     */
    @SerialName("r") val resources: Map<String, ResourceDTO> = emptyMap(),
    @SerialName("ns") val configNewsscreenList: ConfigNewsscreenListDTO? = null,
    @SerialName("p") val playerPaymentPackInfo: PlayerPaymentDTO = PlayerPaymentDTO(),
    @SerialName("ef") val enabledFeatures: List<String> = emptyList(),
    @SerialName("ui") val ui: ClientUIDataDTO? = null,
) {
    companion object {
        fun admin(): PlayerDTO {
            return PlayerDTO(
                id = AdminData.USER_ID,
                defaultCity = CityDTO.admin(),
                configUserLevelId = 1,
                premiumPlayer = false,
                playerName = AdminData.DISPLAY_NAME,
                questBooks = QuestBookManagerVo(),
                inventory = InventoryDTO(),
                cities = emptyList(),
                resources = emptyMap(),
                configNewsscreenList = null,
                playerPaymentPackInfo = PlayerPaymentDTO(),
                enabledFeatures = emptyList(),
                ui = null
            )
        }

        fun newGame(userId: Long, username: String): PlayerDTO {
            return PlayerDTO(
                id = userId,
                defaultCity = CityDTO.newGame(userId, username),
                configUserLevelId = 1,
                premiumPlayer = false,
                playerName = AdminData.DISPLAY_NAME,
                questBooks = QuestBookManagerVo(),
                inventory = InventoryDTO(),
                cities = emptyList(),
                resources = emptyMap(),
                configNewsscreenList = null,
                playerPaymentPackInfo = PlayerPaymentDTO(),
                enabledFeatures = emptyList(),
                ui = null
            )
        }
    }
}
