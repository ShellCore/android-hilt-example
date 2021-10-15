package mx.dev.shell.android.ejemplohilt.core.usecase

import kotlinx.coroutines.flow.Flow

interface Page1UseCase {
    suspend fun queryUserInfo(): Flow<Result<String?>>
}
