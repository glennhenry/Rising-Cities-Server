package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayfieldItemPermissionDTO(
    @SerialName("cid") val permissionConfigId: Long = 0,
    @SerialName("l") val permissionsLeft: Long = 0,
    @SerialName("b") val permissionsBought: Int = 0,
)
