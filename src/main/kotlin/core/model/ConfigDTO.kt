package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `ConfigDTO.as`
 *
 * most types are still placeholdered
 */
@Serializable
data class ConfigDTO(
    @SerialName("p") val playfields: String = "",
    @SerialName("pe") val playfieldsExpansions: String = "",
    @SerialName("pl") val playfieldlayers: String = "",
    @SerialName("pt") val playfieldtypes: String = "",
    @SerialName("l") val levels: String = "",
    @SerialName("i") val items: String = "",
    @SerialName("a") val assists: String = "",
    @SerialName("r") val configResources: List<ConfigResourceDTO> = emptyList(),
    @SerialName("t") val tags: String = "",
    @SerialName("go") val goods: String = "",
    @SerialName("q") val quests: String = "",
    @SerialName("pp") val paymentPacks: String = "",
    @SerialName("pr") val permissions: String = "",
    @SerialName("gr") val restrictions: String = "",
    @SerialName("inv") val inventories: String = "",
    @SerialName("prs") val professionalSpecializations: String = "",
    @SerialName("pra") val professionalAttributes: String = "",
    @SerialName("prl") val configProfessionalLevel: String = "",
    @SerialName("bs") val boosterpacks: String = "",
    @SerialName("ibs") val improvementBoosterPacks: String = "",
    @SerialName("bal") val balanceParameters: String = "",
    @SerialName("re") val runningEvents: String = "",
    @SerialName("ue") val upcomingEvents: String = "",
    @SerialName("prt") val professionalTraits: String = "",
    @SerialName("imp") val improvements: String = "",
    @SerialName("db") val cityImprovements: String = "",
    @SerialName("ft") val features: String = "",
    @SerialName("w") val configCityWheelDTO: String = "",
    @SerialName("mb") val masteryBoni: String = "",
    @SerialName("c") val configCinema: String = "",
    @SerialName("cf") val flashConfig: String = "",
    @SerialName("v") val version: String = ""
)
