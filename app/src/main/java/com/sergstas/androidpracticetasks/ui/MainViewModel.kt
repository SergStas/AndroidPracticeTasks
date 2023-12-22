package com.sergstas.androidpracticetasks.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergstas.androidpracticetasks.data.SingletonRuntimeTodoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: SingletonRuntimeTodoRepo,
): ViewModel() {
    val state get() = _state.asStateFlow()
    private val _state = MutableStateFlow<State>(State.Initial)

    fun loadTodos() {
        viewModelScope.launch {
            // TODO
        }
    }

    // TODO: remaining functionality

    sealed interface State {
        data object Initial: State
        // TODO: states
    }
}