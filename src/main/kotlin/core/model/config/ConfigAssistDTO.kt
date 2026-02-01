package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigAssistDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("t") val type: String = "",
    @SerialName("pId") val connectedPhaseId: Long = 0,
    @SerialName("l") val lifetime: Long = 0,
    @SerialName("lo") val locaId: String = "",
    @SerialName("gf") val gfxId: Long = 0,
    @SerialName("o") val behaviourOutput: Int = 0
)
