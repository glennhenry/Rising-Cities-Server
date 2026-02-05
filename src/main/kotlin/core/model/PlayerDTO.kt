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
        fun newGame(userId: Long, username: String): PlayerDTO {
            // configId is refernece to ConfigResourceDTO ("r" in ConfigDTO)
            // those have types of RES_XP, CURR_VIRT, etc.
            val res = listOf(
                ResourceDTO(1, 1000, 12345, 13000, ""),
                ResourceDTO(2, 1001, 1234, 10000, ""),
                ResourceDTO(3, 1002, 3214, 10000, ""),
                ResourceDTO(4, 1003, 1233, 10000, ""),
                ResourceDTO(5, 1004, 4125, 10000, ""),
                ResourceDTO(6, 1005, 5265, 10000, ""),
                ResourceDTO(7, 1006, 3414, 10000, ""),
                ResourceDTO(8, 1007, 5235, 10000, ""),
                ResourceDTO(9, 1008, 7457, 10000, ""),
                ResourceDTO(10, 1009, 7845, 10000, ""),
                ResourceDTO(11, 1010, 7547, 10000, ""),
                ResourceDTO(12, 1011, 7545, 10000, ""),
                ResourceDTO(13, 1012, 8658, 10000, "")
            )
            val city = CityDTO.newGame(userId, username, res)

            return PlayerDTO(
                id = userId,
                defaultCity = city,
                configUserLevelId = 1,
                premiumPlayer = false,
                playerName = AdminData.DISPLAY_NAME,
                questBooks = QuestBookManagerVo(),
                inventory = InventoryDTO(),
                cities = listOf(city),
                // e.g., "1001" to ResourceDTO(), "1002" to ResourceDTO()
                resources = res.associateBy { it.id.toString() },
                configNewsscreenList = null,
                playerPaymentPackInfo = PlayerPaymentDTO(),
                enabledFeatures = emptyList(),
                ui = ClientUIDataDTO()
            )
        }
    }
}
