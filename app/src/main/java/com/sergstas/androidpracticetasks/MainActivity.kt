package com.sergstas.androidpracticetasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.sergstas.androidpracticetasks.databinding.ActivityMainBinding
import com.sergstas.androidpracticetasks.models.UserStatus
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeState()
        onLoading(false)
    }

    private fun observeState() {
        MainScope().launch {
            viewModel.state.collect {
                when (it) {
                    MainViewModel.State.Finished -> onLoading(false)
                    is MainViewModel.State.Progress -> displayProgress(it.percents)
                    MainViewModel.State.Started -> onLoading(true)
                    // TODO:
                    // Handle State.Result calling displayResults() method
                }
            }
        }
    }

    private fun displayResults(data: UserStatus) =
        binding.run {
            llResults.isVisible = true
            tvEmpty.isVisible = false
            tvName.text = "User: ${data.username}"
            tvStatus.text = "Status: ${data.status}"
        }

    private fun displayProgress(percents: Int) {
        // TODO:
        // Display percents% into tvProgress
    }

    private fun onLoading(started: Boolean) =
        binding.run {
            tvProgress.isVisible = started
            pbLoading.isVisible = started
            bLaunch.text = if (started) "abort" else "launch"
            bLaunch.setOnClickListener {
                if (started) viewModel.stop()
                else viewModel.launch()
            }
        }
}