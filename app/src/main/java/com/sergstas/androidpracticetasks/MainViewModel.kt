package com.sergstas.androidpracticetasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    companion object {
        const val WORK_DURATION = 5000L
    }

    val msg: LiveData<String?> get() = _msg
    private val _msg = MutableLiveData<String?>()

    val dispatcher: LiveData<CoroutineDispatcher> get() = _dispatcher
    private val _dispatcher = MutableLiveData<CoroutineDispatcher>(Dispatchers.Main)

    fun doWorkOnVmScope() {
        viewModelScope.launch {
            withContext(dispatcher.value!!) {
                doWork()
            }
        }
        // Call doWork() inside viewModelScope using dispatcher's context
    }

    fun switchDispatcher() {
        if (_dispatcher.value == Dispatchers.Main) _dispatcher.value = Dispatchers.IO
            else _dispatcher.value = Dispatchers.Main
        // switch value of '_dispatcher' between Main and IO
    }

    private suspend fun doWork() {
        _msg.value = "Work started"
        delay(WORK_DURATION)
        _msg.value = "Work ended"
    }
}