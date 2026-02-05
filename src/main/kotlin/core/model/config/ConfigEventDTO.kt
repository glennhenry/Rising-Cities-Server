package core.model.config

import annotation.RevisitLater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@RevisitLater("constants")
// l is used twice, as a number and as an array, probably one is for [ConfigEventSaleDTO]
// See `ConfigEventDTO.as` constructor
@Serializable
data class ConfigEventDTO(
    @SerialName("id") val id: Long = 1,
//    @SerialName("l") val levelId: Long = 1,
    @SerialName("tt") val totalAvailabilityTime: Long = 0,
    @SerialName("st") val availabilityTimeStart: Long = 0,
    @SerialName("y") val eventType: String = "",
    @SerialName("l") val levelRestricts: List<ConfigEventLevel> = emptyList(),
)
