package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
@Serializable
data class ConfigProfessionalAttributeDTO(
    @SerialName("cpai") val id: Long = 1,
    @SerialName("cat") val attributeType: String = "",
    @SerialName("max") val maxCap: Int = 0,
    @SerialName("ats") val attributeThresholds: List<ConfigProfessionalAttributeThresholdDTO> = emptyList(),
)
