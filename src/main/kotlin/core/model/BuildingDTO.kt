package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class BuildingDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("c") val configId: Int = 0,
    @SerialName("x") val posX: Int = 0,
    @SerialName("y") val posY: Int = 0,
    @SerialName("cr") val created: Int = 0,
    @SerialName("l") val buildingLevel: Int = 0,
    @SerialName("co") val condition: Int = 0,
    @SerialName("d") val dirty: Int = 0,
    @SerialName("a") val active: Boolean = false,
    @SerialName("upc") val upgradeCount: Int = 0,
    @SerialName("lu") val lastUpdatedTimeStamp: Int = 0,
    @SerialName("e") val emergencyDTO: EmergencyDTO? = null,
    @SerialName("ph") val activePhases: List<PhaseDTO>? = null,
    @SerialName("n") val needProductStock: List<NeedStockDTO>? = null,
    @SerialName("pr") val professionals: List<ProfessionalDTO>? = null,
    @SerialName("sl") val improvementSlotIds: List<Int>? = null,
    @SerialName("imp") val improvements: List<ImprovementDTO>? = null,
    @SerialName("mb") val currentMasteryBonus: Int? = null,
    @SerialName("m") val currentMasteryChallenge: MasteryChallengeDTO? = null,
)
