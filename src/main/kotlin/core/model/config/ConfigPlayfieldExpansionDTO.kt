package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigPlayfieldExpansionDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("pf") val playfieldId: Long = 1,
    @SerialName("px") val px: Long = 0,
    @SerialName("py") val py: Long = 0,
    @SerialName("sx") val sx: Long = 0,
    @SerialName("sy") val sy: Long = 0,
    @SerialName("gf") val gfx: Int = 0,
    @SerialName("it") val itemType: Int = 0,
    @SerialName("fp") val preload: Boolean = false,
    @SerialName("fl") val localid: Long = 1,
    @SerialName("np") val normalPrice: Int = 0,
    @SerialName("pp") val premiumPrice: Int = 0,
    @SerialName("nx") val neighbourIDList: List<Long> = emptyList(),
    @SerialName("icpi") val initialPlayfieldItems: List<ConfigInitialPlayfieldItemDTO> = emptyList(),
    @SerialName("e") val listOfEventIds: List<Long> = emptyList(),
)
