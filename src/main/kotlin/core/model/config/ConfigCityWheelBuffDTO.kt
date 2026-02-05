package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigCityWheelBuffDTO(
    @SerialName("i") val id: Long = 1,
    @SerialName("g") val gfxId: Long = 1,
    @SerialName("l") val localeId: String = "",
    @SerialName("o") val specialOutput: ConfigOutputDTO? = null,
)
