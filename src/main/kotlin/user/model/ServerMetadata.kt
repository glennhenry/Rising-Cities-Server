package user.model

import kotlinx.serialization.Serializable

/**
 * Data owned by a specific player but is an extra and managed at the server level.
 *
 * This may include feature flags, progression milestones, or
 * temporary states that are not part of core player profile data.
 *
 * @property flags userId: flag
 * @property extra userId: extra
 */
@Serializable
data class ServerMetadata(
    val flags: Map<Long, Boolean> = emptyMap(),
    val extra: Map<Long, String> = emptyMap(),
)
