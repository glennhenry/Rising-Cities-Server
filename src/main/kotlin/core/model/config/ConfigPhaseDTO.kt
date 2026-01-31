package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPhaseDTO(
    @SerialName("eo") val listEntryOutputs: List<ConfigOutputDTO>? = null,
    @SerialName("to") val listTriggerOutput: List<ConfigOutputDTO>? = null,
    @SerialName("ifc") val instantFinshOutput: List<ConfigOutputDTO>? = null,
    @SerialName("d") val duration: ConfigDurationVo? = null,
    @SerialName("oid") val phaseOrderId: Int = 0,
    @SerialName("t") val phaseType: String = "",
    @SerialName("pid") val phaseId: Int = 0,
)
