package core.model.config

import core.model.constants.ServerFeatureConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigFeatureDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("type") val type: String = ServerFeatureConstants.EXPANSION,
    @SerialName("rq") val requirements: List<ConfigFeatureRequirementDTO> = emptyList(),
) {
    init {
        require(type in ServerFeatureConstants.ALL || type == "") {
            "Invalid constants: $type"
        }
    }
}
