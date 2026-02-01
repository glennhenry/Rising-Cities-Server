package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigCityWheelDTO(
    @SerialName("cb") val wheelBuffs: List<ConfigCityWheelBuffDTO> = emptyList(),
    @SerialName("e") val listOfEventIds: List<Long> = emptyList(),
)
