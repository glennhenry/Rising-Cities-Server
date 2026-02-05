package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldItemPermissionDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("p") val initialPermissions: Int = 0,
    @SerialName("bc") val buyCap: Int = 0,
    @SerialName("c") val realCurrencyCost: Int = 0,
    @SerialName("m") val modifier: Long = 0,
    @SerialName("e") val eventIdList: List<Long> = emptyList(),
)
