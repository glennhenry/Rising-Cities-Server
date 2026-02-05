package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigMasteryChallengeDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("t") val targetProgress: Int = 0,
    @SerialName("l") val locaID: String = "",
    @SerialName("n") val nextChallenge: ConfigMasteryChallengeDTO? = null,
    @SerialName("b") val bonusId: Long = 1,
    @SerialName("ic") val instantFinishCosts: Int = 0,
)
