package core.model

import core.model.config.ConfigOutputDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoulderDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("c") val configId: Long = 1,
    @SerialName("px") val posX: Long = 1,
    @SerialName("py") val posY: Long = 1,
    @SerialName("cr") val created: Long = 1,
    @SerialName("o") val currentOutput: List<ConfigOutputDTO>? = null,
    @SerialName("ph") val activePhases: List<PhaseDTO>? = null,
)
