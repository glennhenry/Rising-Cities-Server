package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigUpcomingEventDTO(
    @SerialName("e") val configEvent: ConfigEventDTO = ConfigEventDTO(),
    @SerialName("l") val locaId: String = "",
    @SerialName("gId") val gfxId: Long = 1,
)
