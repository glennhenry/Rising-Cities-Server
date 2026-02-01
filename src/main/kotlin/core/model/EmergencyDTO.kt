package core.model

import core.model.config.ConfigEmergencyDTO
import core.model.config.ConfigOutputDTO
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class EmergencyDTO(
    @SerialName("t") val endTime: Int = 0,
    @SerialName("r") val rewardOrCosts: List<ConfigOutputDTO>? = null,
    @SerialName("s") val status: String = "",
    @SerialName("c") val config: ConfigEmergencyDTO = ConfigEmergencyDTO()
)
