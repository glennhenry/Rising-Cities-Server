package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigEducationStepDTO(
    @SerialName("step") val step: Int = 0,
    @SerialName("gc") val goodCost: Int = 0,
    @SerialName("rc") val resourceCost: Int = 0,
    @SerialName("min") val minSkillPointAdded: Int = 0,
    @SerialName("max") val maxSkillPointAdded: Int = 0,
)
