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
                resources = listOf(
                    ResourceDTO(1, 1000, 1000, 10000, ""),
                    ResourceDTO(1, 1001, 1000, 10000, ""),
                    ResourceDTO(1, 1002, 1000, 10000, ""),
                    ResourceDTO(1, 1003, 1000, 10000, ""),
                    ResourceDTO(1, 1004, 1000, 10000, ""),
                    ResourceDTO(1, 1005, 1000, 10000, ""),
                    ResourceDTO(1, 1006, 1000, 10000, ""),
                    ResourceDTO(1, 1007, 1000, 10000, ""),
                    ResourceDTO(1, 1008, 1000, 10000, ""),
                    ResourceDTO(1, 1009, 1000, 10000, ""),
                    ResourceDTO(1, 1010, 1000, 10000, ""),
                    ResourceDTO(1, 1011, 1000, 10000, ""),
                    ResourceDTO(1, 1012, 1000, 10000, ""),
                ),
                phases = emptyList(),
                cityWheel = null,
                cinema = null,
                improvements = emptyList(),
            )
        }
    }
}
