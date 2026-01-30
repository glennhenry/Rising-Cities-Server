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
    @SerialName("p") val playfieldDTO: String = "",
    @SerialName("pe") val playfieldExpansionDTO: String = "",
    @SerialName("pl") val playfieldLayerDTO: String = "",
    @SerialName("pt") val playfieldTypeDTO: String = "",
    @SerialName("l") val userLevelDTO: String = "",
    @SerialName("i") val playfieldItemDTO: String = "",
    @SerialName("a") val assistDTO: String = "",
    @SerialName("r") val resourceDTO: String = "",
    @SerialName("t") val tagDTO: String = "",
    @SerialName("go") val goodDTO: String = "",
    @SerialName("q") val questDTO: String = "",
    @SerialName("pp") val paymentPackDTO: String = "",
    @SerialName("pr") val playfieldItemPermissionDTO: String = "",
    @SerialName("gr") val groundRestrictionDTO: String = "",
    @SerialName("inv") val inventoryDTO: String = "",
    @SerialName("prs") val professionalSpecializationDTO: String = "",
    @SerialName("pra") val professionalAttributeDTO: String = "",
    @SerialName("prl") val professionalLevelDTO: String = "",
    @SerialName("bs") val boosterDTO: String = "",
    @SerialName("ibs") val improvementBoosterDTO: String = "",
    @SerialName("bal") val balanceDTO: String = "",
    @SerialName("re") val eventDTO: String = "",
    @SerialName("ue") val upcomingEventDTO: String = "",
    @SerialName("prt") val professionalTraitDTO: String = "",
    @SerialName("imp") val improvementDTO: String = "",
    @SerialName("db") val cityImprovementDTO: String = "",
    @SerialName("ft") val featureDTO: String = "",
    @SerialName("w") val cityWheelDTO: String = "",
    @SerialName("mb") val masteryBonusDTO: String = "",
    @SerialName("c") val cinemaDTO: String = "",
    @SerialName("cf") val mapEntryDTO: String = "",
    @SerialName("v") val version: String = ""
)
