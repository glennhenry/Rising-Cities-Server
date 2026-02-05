package core.model.config

import core.model.constants.ServerAssistTypeConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigAssistDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("t") val type: String = ServerAssistTypeConstants.EMERGENCY_SPAWNRATE,
    @SerialName("pId") val connectedPhaseId: Long = 1,
    @SerialName("l") val lifetime: Long = 0,
    @SerialName("lo") val locaId: String = "",
    @SerialName("gf") val gfxId: Long = 1,
    @SerialName("o") val behaviourOutput: Int = 0
) {
    init {
        require(type in ServerAssistTypeConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
