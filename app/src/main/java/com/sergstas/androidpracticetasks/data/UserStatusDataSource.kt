package com.sergstas.androidpracticetasks.data

import com.sergstas.androidpracticetasks.models.UserStatus
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class UserStatusDataSource {
    companion object {
        private const val DURATION = 5000L
    }

    private val usernames = listOf("Valera", "Aboba", "Enotik", "Bivis")

    fun runAsFlow() =
        flow<LoadingState> {
            val delayDuration = DURATION / 100
            // TODO:
            // Emit 0-100% LoadingState.Progress() before result with delay(delayDuration) between each

            val result = UserStatus(
                username = usernames.random(),
                status = if (Random.nextBoolean()) UserStatus.Status.Offline else UserStatus.Status.Online,
            )
            emit(LoadingState.Data(result))
        }

    sealed interface LoadingState {
        data class Progress(val percents: Int): LoadingState
        data class Data(val userStatus: UserStatus): LoadingState
    }
}