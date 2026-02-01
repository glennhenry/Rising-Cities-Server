package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientUIDataDTO(
    @SerialName("lowTrf") val lowTraffic: Boolean = false,
    @SerialName("lowGq") val lowGraphicsQuality: Boolean = false,
    @SerialName("hTips") val increasingTips: Boolean = true,
    @SerialName("hFloater") val increasingSimbols: Boolean = true,
    @SerialName("fastIlayer") val fasterNotification: Boolean = false,
    @SerialName("fsOn") val fullscreenActive: Boolean = false,
    @SerialName("soundOn") val soundActive: Boolean = true,
    @SerialName("rc") val rcVerification: Boolean = false,
    @SerialName("vpi") val viewedPlayfieldItemConfigIds: List<Long> = emptyList(),
    @SerialName("vq") val viewedQuests: List<Long> = emptyList(),
)









