package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigAssistDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("t") val type: String = "",
    @SerialName("pId") val connectedPhaseId: Int = 0,
    @SerialName("l") val lifetime: Int = 0,
    @SerialName("lo") val locaId: String = "",
    @SerialName("gf") val gfxId: Int = 0,
    @SerialName("o") val behaviourOutput: Int = 0,
)
