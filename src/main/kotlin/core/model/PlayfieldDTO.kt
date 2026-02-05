package core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

/**
 * Does not mirror client fully, only what `ServerMidSessionLoginSuccessCommand` needs.
 */
@Serializable
data class PlayfieldDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val configId: Long = 1,
    @SerialName("x") val sizeX: Long = 1,
    @SerialName("y") val sizeY: Long = 1,
    @SerialName("sx") val startX: Long = 1,
    @SerialName("sy") val startY: Long = 1,
    @SerialName("pe") val expansions: List<PlayfieldExpansionDTO> = emptyList(),
    @SerialName("bo") val boulders: List<BoulderDTO> = emptyList(),
    @SerialName("r") val resources: List<ResourceDTO> = emptyList(),
    @SerialName("bg") val buffs: List<PhaseDTO> = emptyList(),
)
