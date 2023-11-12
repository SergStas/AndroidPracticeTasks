package com.sergstas.androidpracticetasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergstas.androidpracticetasks.data.UserStatusDataSource
import com.sergstas.androidpracticetasks.models.UserStatus
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val dataSource = UserStatusDataSource()
    private var job: Job? = null

    val state get() = _state.asSharedFlow()
    private val _state = MutableSharedFlow<State>()

    fun launch() {
        job?.cancel()
        job = viewModelScope.launch {
            // TODO
            // invoke dataSource.runAsFlow and collect each state, mapping and emitting it into _state.emit(it)
            // Also emit State.Started before collecting and State.Finished after
        }
    }

    fun stop() {
        viewModelScope.launch {
            // TODO
            // Implement cancellation of job, also immediately emit State.Finished
        }
    }

    sealed interface State {
        data object Started: State
        data class Progress(val percents: Int): State
        data class Result(val data: UserStatus): State
        data object Finished: State
    }
}