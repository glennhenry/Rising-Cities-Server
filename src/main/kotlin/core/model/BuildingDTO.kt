package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class BuildingDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val configId: Long = 1,
    @SerialName("x") val posX: Long = 0,
    @SerialName("y") val posY: Long = 0,
    @SerialName("cr") val created: Long = 0,
    @SerialName("l") val buildingLevel: Long = 0,
    @SerialName("co") val condition: Long = 0,
    @SerialName("d") val dirty: Long = 0,
    @SerialName("a") val active: Boolean = false,
    @SerialName("upc") val upgradeCount: Int = 0,
    @SerialName("lu") val lastUpdatedTimeStamp: Long = 0,
    @SerialName("e") val emergencyDTO: EmergencyDTO? = null,
    @SerialName("ph") val activePhases: List<PhaseDTO>? = null,
    @SerialName("n") val needProductStock: List<NeedStockDTO>? = null,
    @SerialName("pr") val professionals: List<ProfessionalDTO>? = null,
    @SerialName("sl") val improvementSlotIds: List<Long>? = null,
    @SerialName("imp") val improvements: List<ImprovementDTO>? = null,
    @SerialName("mb") val currentMasteryBonus: MasteryBonusDTO? = null,
    @SerialName("m") val currentMasteryChallenge: MasteryChallengeDTO? = null,
)
