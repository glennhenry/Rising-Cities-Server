package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import core.model.config.ConfigResourceDTO
import core.model.config.ConfigDTO

/**
 * `ResourceDTO.as`
 *
 * Note: this `ResourceDTO` does not fully mirror the client-side version.
 *
 * Client-side initialization requires both a `configId` and the corresponding
 * [ConfigResourceDTO], which are delivered in different phases:
 * - `ConfigResourceDTO` during [ConfigDTO] loading
 * - `ResourceDTO` later as part of [CityDTO]
 *
 * Therefore, this server-side DTO only models what is required on the server.
 *
 * Note: This is similar to other DTOs that depends on `ConfigFactory.as` for construction.
 */
@Serializable
data class ResourceDTO(
    @SerialName("id") val id: Long = 0,
    @SerialName("c") val configId: Long = 0,
    @SerialName("a") val amount: Long = 0,
    @SerialName("ac") val amountCap: Long = 0,
    @SerialName("imagePath") val imagePath: String = "",
)
