package com.sergstas.androidpracticetasks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergstas.androidpracticetasks.data.SingletonRuntimeTodoRepo
import com.sergstas.androidpracticetasks.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel(SingletonRuntimeTodoRepo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
        observeState()
        loadTodos()
    }

    private fun observeState() =
        MainScope().launch {
            viewModel.state.collect {
                when (it) {

                    else -> {}
                }
            }
        }

    private fun setView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun loadTodos() =
        viewModel.loadTodos()
}

