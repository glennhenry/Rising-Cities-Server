package core.model.config

import core.model.constants.ServerFeatureConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigFeatureRequirementDTO(
    @SerialName("eid") val correspondingConfigId: Long = 1,
    @SerialName("t") val type: String = ServerFeatureConstants.EXPANSION,
) {
    init {
        require(type in ServerFeatureConstants.ALL) {
            "Invalid constants: $type"
        }
    }
}
