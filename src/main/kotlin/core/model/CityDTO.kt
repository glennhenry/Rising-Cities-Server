package core.model

import core.data.AdminData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `CityDTO.as`
 */
@Serializable
data class CityDTO(
    @SerialName("id") val id: Long = 1,
    @SerialName("n") val name: String = "",
    @SerialName("p") val playfields: List<PlayfieldLightVo> = emptyList(),
    @SerialName("r") val resources: List<ResourceDTO> = emptyList(),
    @SerialName("ph") val phases: List<PhaseDTO> = emptyList(),
    @SerialName("w") val cityWheel: List<CityWheelDTO>? = null,
    @SerialName("c") val cinema: CinemaDTO? = null,
    @SerialName("imp") val improvements: List<ImprovementDTO> = emptyList(),
) {
    companion object {
        fun admin(): CityDTO {
            return CityDTO(
                id = AdminData.USER_ID,
                name = AdminData.DISPLAY_NAME,
                playfields = emptyList(),
                resources = emptyList(),
                phases = emptyList(),
                cityWheel = null,
                cinema = null,
                improvements = emptyList(),
            )
        }

        fun newGame(userId: Long, username: String): CityDTO {
            return CityDTO(
                id = userId,
                name = username,
                playfields = emptyList(),
                resources = emptyList(),
                phases = emptyList(),
                cityWheel = null,
                cinema = null,
                improvements = emptyList(),
            )
        }
    }
}
