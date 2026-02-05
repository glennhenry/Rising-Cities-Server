package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class InventoryItemDTO(
    @SerialName("bid") val id: Long = 1,
    @SerialName("b") val buildingDTO: BuildingDTO? = null,
    // named as decorationVo, constructed from DecorationVo but reqwuire DecorationDTO
    @SerialName("d") val decorationDTO: DecorationDTO? = null,
    @SerialName("imp") val improvementDTO: ImprovementDTO? = null,
    @SerialName("g") val goodDTO: GoodDTO? = null,
    @SerialName("p") val permissionDTO: PlayfieldItemPermissionDTO? = null,
    @SerialName("del") val shouldBeRemoved: Boolean = false,
    @SerialName("a") val amount: Long = 0,
)
