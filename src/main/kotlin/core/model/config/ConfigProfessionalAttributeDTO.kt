package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigProfessionalAttributeDTO(
    @SerialName("cpai") val id: Int = 0,
    @SerialName("cat") val attributeType: String = "",
    @SerialName("max") val maxCap: Int = 0,
    @SerialName("ats") val attributeThresholds: List<ConfigProfessionalAttributeThresholdDTO> = emptyList(),
)
