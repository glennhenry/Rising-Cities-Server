package core.model.config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigPlayfieldDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("t") val typeId: Long = 1,
    @SerialName("l") val levelId: Long = 1,
    @SerialName("gf") val gfxId: Long = 1,
    @SerialName("x") val maxX: Long = 0,
    @SerialName("y") val maxY: Long = 0,
    @SerialName("ev") val expansionValue: Int,
    // anonymous variable: if (param1.m), read param1.ma
    @SerialName("m") val hasMasteryChallenge: Boolean = false,
    @SerialName("ma") val masteryChallenge: ConfigMasteryChallengeDTO = ConfigMasteryChallengeDTO(),
)
