package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `CityDTO.as`
 */
@Serializable
data class CityDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("n") val name: String = "",
    @SerialName("p") val playfields: List<String> = emptyList(),
    @SerialName("r") val resources: List<ResourceDTO> = emptyList(),
    @SerialName("ph") val phases: List<String> = emptyList(),
    @SerialName("w") val cityWheel: List<String> = emptyList(),
    @SerialName("c") val cinema: String = "",
    @SerialName("imp") val improvements: List<String> = emptyList(),
)
