package user

import data.collection.PlayerAccount

/**
 * Repository for [PlayerAccount].
 */
interface PlayerAccountRepository {
    suspend fun doesUsernameExist(username: String): Result<Boolean>
    suspend fun isUsernameAvailable(username: String): Result<Boolean>
    suspend fun doesEmailExist(email: String): Result<Boolean>
    suspend fun isEmailAvailable(email: String): Result<Boolean>

    suspend fun getPlayerAccountByName(username: String): Result<PlayerAccount>
    suspend fun getPlayerAccountById(userId: String): Result<PlayerAccount>
    suspend fun getUserIdFromName(username: String): Result<String>

    suspend fun updatePlayerAccount(userId: String, account: PlayerAccount): Result<Unit>
    suspend fun updateLastLogin(userId: String, lastLogin: Long): Result<Unit>

    /**
     * Confirm the player's password matches the stored credentials for the given username
     *
     * @return The associated `userId` if correct.
     *         Returns `null` if account don't exist or password is wrong.
     */
    suspend fun verifyCredentials(username: String, password: String): Result<String>
}
