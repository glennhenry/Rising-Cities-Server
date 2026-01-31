package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldExpansionDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("pf") val playfieldId: Int = 0,
    @SerialName("px") val px: Int = 0,
    @SerialName("py") val py: Int = 0,
    @SerialName("sx") val sx: Int = 0,
    @SerialName("sy") val sy: Int = 0,
    @SerialName("gf") val gfx: Int = 0,
    @SerialName("it") val itemType: Int = 0,
    @SerialName("fp") val preload: Boolean = false,
    @SerialName("fl") val localid: Int = 0,
    @SerialName("np") val normalPrice: Int = 0,
    @SerialName("pp") val premiumPrice: Int = 0,
    @SerialName("nx") val neighbourIDList: List<Int> = emptyList(),
    @SerialName("icpi") val initialPlayfieldItems: List<ConfigInitialPlayfieldItemDTO> = emptyList(),
    @SerialName("e") val listOfEventIds: List<Int> = emptyList(),
)
