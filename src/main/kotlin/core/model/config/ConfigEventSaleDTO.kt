package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// inherits [ConfigEventDTO]
@Serializable
data class ConfigEventSaleDTO(
    @SerialName("id") val id: Int = 0,
//    @SerialName("l") val levelId: Int = 0,
    @SerialName("tt") val totalAvailabilityTime: Int = 0,
    @SerialName("st") val availabilityTimeStart: Int = 0,
    @SerialName("y") val eventType: String = "",
    @SerialName("l") val levelRestricts: List<ConfigEventLevel> = emptyList(),
    @SerialName("s") val listOfAffectedResources: List<ConfigOutputDTO> = emptyList(),
)
