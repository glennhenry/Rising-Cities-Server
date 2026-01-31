package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigBalanceDTO(
    @SerialName("key") val key: String = "",
    @SerialName("val") val value: Int = 0,
)
