package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// l is used twice, as a number and as an array, probably one is for [ConfigEventSaleDTO]
// See `ConfigEventDTO.as` constructor
@Serializable
data class ConfigEventDTO(
    @SerialName("id") val id: Int = 0,
//    @SerialName("l") val levelId: Int = 0,
    @SerialName("tt") val totalAvailabilityTime: Int = 0,
    @SerialName("st") val availabilityTimeStart: Int = 0,
    @SerialName("y") val eventType: String = "",
    @SerialName("l") val levelRestricts: List<ConfigEventLevel> = emptyList(),
)
