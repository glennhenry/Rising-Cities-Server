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
    @SerialName("c") val cinema: CinemaDTO = CinemaDTO(),
    @SerialName("imp") val improvements: List<ImprovementDTO> = emptyList(),
) {
    companion object {
        fun newGame(userId: Long, username: String, res: List<ResourceDTO>): CityDTO {
            return CityDTO(
                id = userId,
                name = username,
                playfields = emptyList(),
                resources = res,
                phases = emptyList(),
                cityWheel = null,
                cinema = CinemaDTO(),
                improvements = emptyList(),
            )
        }
    }
}
