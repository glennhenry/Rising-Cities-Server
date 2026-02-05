package core.model.config

import core.model.constants.ServerPhaseType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPhaseDTO(
    @SerialName("eo") val listEntryOutputs: List<ConfigOutputDTO>? = null,
    @SerialName("to") val listTriggerOutput: List<ConfigOutputDTO>? = null,
    @SerialName("ifc") val instantFinshOutput: List<ConfigOutputDTO>? = null,
    @SerialName("d") val duration: ConfigDurationVo? = null,
    @SerialName("oid") val phaseOrderId: Long = 1,
    @SerialName("t") val phaseType: String = ServerPhaseType.UPGRADE,
    @SerialName("pid") val phaseId: Long = 1,
) {
    init {
        require(phaseType in ServerPhaseType.ALL || phaseType == "") {
            "Invalid constants: $phaseType"
        }
    }
}
