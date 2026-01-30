package core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * `ResourceDTO.as`
 *
 * note: this `ResourceDTO` don't mirror client-side exactly,
 * because there is "two" ResourceDTO.
 *
 * The first is the intermediate object, which have all the fields listed here.
 * The first version is what we need on server for client to build the second.
 *
 * The second is the actual DTO on `ResourceDTO.as`, needing the first object
 * from server and the second [ConfigResourceDTO] which is also from server.
 */
@Serializable
data class ResourceDTO(
    @SerialName("id") val id: Int = 0,
    @SerialName("c") val configId: Int = 0,
    @SerialName("a") val amount: Int = 0,
    @SerialName("ac") val amountCap: Int = 0,
    @SerialName("imagePath") val imagePath: String = "",
)
