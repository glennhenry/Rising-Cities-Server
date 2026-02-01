package core.model.config

import core.model.MapEntryDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `ConfigDTO.as`
 *
 * Config should ideally be written on external JSON file.
 * These configs aren't really mutated in the server, and only for one-time initialization
 * for the game client. In other words, this data class and all the children isn't
 * needed to make the configs, but they serve as a schema reference to create
 * the JSON (can write details, comment, or notice here).
 */
@Serializable
data class ConfigDTO(
    @SerialName("p") val playfields: List<ConfigPlayfieldDTO> = emptyList(),
    @SerialName("pe") val playfieldsExpansions: List<ConfigPlayfieldExpansionDTO> = emptyList(),
    @SerialName("pl") val playfieldlayers: List<ConfigPlayfieldLayerDTO> = emptyList(),
    @SerialName("pt") val playfieldtypes: List<ConfigPlayfieldTypeDTO> = emptyList(),
    @SerialName("l") val levels: List<ConfigUserLevelDTO> = emptyList(),
    @SerialName("i") val items: List<ConfigPlayfieldItemDTO> = emptyList(),
    @SerialName("a") val assists: List<ConfigAssistDTO> = emptyList(),
    @SerialName("r") val configResources: List<ConfigResourceDTO> = emptyList(),
    @SerialName("t") val tags: List<ConfigTagDTO> = emptyList(),
    @SerialName("go") val goods: List<ConfigGoodDTO> = emptyList(),
    @SerialName("q") val quests: List<ConfigQuestDTO> = emptyList(),
    @SerialName("pp") val paymentPacks: List<ConfigPaymentPackDTO> = emptyList(),
    @SerialName("pr") val permissions: List<ConfigPlayfieldItemPermissionDTO> = emptyList(),
    @SerialName("gr") val restrictions: List<ConfigGroundRestrictionDTO> = emptyList(),
    @SerialName("inv") val inventories: List<ConfigInventoryDTO> = emptyList(),
    @SerialName("prs") val professionalSpecializations: List<ConfigProfessionalSpecializationDTO> = emptyList(),
    @SerialName("pra") val professionalAttributes: List<ConfigProfessionalAttributeDTO> = emptyList(),
    @SerialName("prl") val configProfessionalLevel: List<ConfigProfessionalLevelDTO> = emptyList(),
    @SerialName("bs") val boosterpacks: List<ConfigBoosterDTO> = emptyList(),
    @SerialName("ibs") val improvementBoosterPacks: List<ConfigBoosterDTO> = emptyList(),
    @SerialName("bal") val balanceParameters: List<ConfigBalanceDTO> = emptyList(),
    @SerialName("re") val runningEvents: List<ConfigEventDTO> = emptyList(),
    @SerialName("ue") val upcomingEvents: List<ConfigUpcomingEventDTO> = emptyList(),
    @SerialName("prt") val professionalTraits: List<ConfigProfessionalTraitDTO> = emptyList(),
    @SerialName("imp") val improvements: List<ConfigImprovementDTO> = emptyList(),
    @SerialName("db") val cityImprovements: List<ConfigImprovementDTO> = emptyList(),
    @SerialName("ft") val features: List<ConfigFeatureDTO> = emptyList(),
    @SerialName("w") val configCityWheelDTO: List<ConfigCityWheelDTO> = emptyList(),
    @SerialName("mb") val masteryBoni: List<ConfigMasteryBonusDTO> = emptyList(),
    @SerialName("c") val configCinema: List<ConfigCinemaDTO> = emptyList(),
    @SerialName("cf") val flashConfig: List<MapEntryDTO> = emptyList(),
    @SerialName("v") val version: Long = 0
)


