package mx.dev.shell.android.ejemplohilt.core.usecase

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class Page1UseCaseImpl @Inject constructor(): Page1UseCase {

    override suspend fun queryUserInfo(): Flow<Result<String?>> {
        return flow {
            delay(4000)
            emit(Result.success("La inyección jaló chido!!!1 XDXD"))
            delay(2000)
            emit(Result.success("El segundo valor también llegó!!!"))
            delay(2000)
            emit(Result.success(null))
            emit(Result.failure(Exception("Me morí :P")))
        }
    }
}