package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigCityWheelBuffDTO(
    @SerialName("i") val id: Long = 0,
    @SerialName("g") val gfxId: Long = 0,
    @SerialName("l") val localeId: String = "",
    @SerialName("o") val specialOutput: ConfigOutputDTO? = null,
)
