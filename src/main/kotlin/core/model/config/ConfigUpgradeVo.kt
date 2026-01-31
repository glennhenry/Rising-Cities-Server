package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// nothing, there was nothing listed in the client
@Serializable
data class ConfigUpgradeVo(
    @SerialName("nothing") val nothing: Int = 0,
)
