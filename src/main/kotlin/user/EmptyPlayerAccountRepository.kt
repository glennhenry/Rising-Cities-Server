package user

import data.collection.PlayerAccount

/**
 * Empty implementation (no operation) of [PlayerAccountRepository] only used for testing purposes.
 */
class EmptyPlayerAccountRepository : PlayerAccountRepository {
    override suspend fun doesUsernameExist(username: String): Result<Boolean> = TODO("ONLY TEST")
    override suspend fun isUsernameAvailable(username: String): Result<Boolean> = TODO("ONLY TEST")
    override suspend fun doesEmailExist(email: String): Result<Boolean> = TODO("ONLY TEST")
    override suspend fun isEmailAvailable(email: String): Result<Boolean>  = TODO("ONLY TEST")
    override suspend fun getPlayerAccountByName(username: String): Result<PlayerAccount> = TODO("ONLY TEST")
    override suspend fun getPlayerAccountById(userId: String): Result<PlayerAccount> = TODO("ONLY TEST")
    override suspend fun getUserIdFromName(username: String): Result<String> = TODO("ONLY TEST")
    override suspend fun updatePlayerAccount(userId: String, account: PlayerAccount): Result<Unit> = TODO("ONLY TEST")
    // called in unit tests
    override suspend fun updateLastLogin(userId: String, lastLogin: Long): Result<Unit> = Result.success(Unit)
    override suspend fun verifyCredentials(username: String, password: String): Result<String> = TODO("ONLY TEST")
}
