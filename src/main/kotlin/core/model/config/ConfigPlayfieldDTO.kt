package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldDTO(
    @SerialName("id") val id: String = "",
    @SerialName("t") val typeId: String = "",
    @SerialName("l") val levelId: String = "",
    @SerialName("gf") val gfxId: String = "",
    @SerialName("x") val maxX: String = "",
    @SerialName("y") val maxY: String = "",
    @SerialName("ev") val expansionValue: String = "",
    // if (param1.m), read param1.ma
    @SerialName("m") val hasMasteryChallenge: Boolean = false,
    @SerialName("ma") val masteryChallenge: ConfigMasteryChallengeDTO = ConfigMasteryChallengeDTO(),
)
