package com.sergstas.androidpracticetasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sergstas.androidpracticetasks.databinding.FragmentMainBinding
import com.sergstas.androidpracticetasks.util.colorFromId
import com.sergstas.androidpracticetasks.util.toast
import kotlinx.coroutines.delay

class MainFragment: Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel = MainViewModel()
    private var isBlue = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeState()
        setView()
    }

    private fun switchColor() {
        isBlue = !isBlue
        binding.root.setBackgroundColor(requireContext().colorFromId(
            if (isBlue) R.color.blue else R.color.pink,
        ))
    }

    private fun setView() {
        binding.run {
            switchDispatcher.setOnClickListener {
                viewModel.switchDispatcher()
            }
            bSwitch.setOnClickListener { switchColor() }
            bBlock.setOnClickListener { runBlocking() }
            bMain.setOnClickListener { runMainScope() }
            bVmScope.setOnClickListener { runVmScope() }
        }
    }

    private fun observeState() {
        viewModel.run {
            msg.observe(viewLifecycleOwner) {
                it?.run { requireContext().toast(this) }
            }
            dispatcher.observe(viewLifecycleOwner) {
                // TODO:
                // Display name of current dispatcher in field tvDispatcher
            }
        }
    }

    private fun runMainScope() {
        // TODO:
        // Call doWork() function using MainScope
    }

    private fun runBlocking() {
        // TODO:
        // Call doWork() function using runBlocking
    }

    private fun runVmScope() {
        // TODO:
        // Call viewModel's doWorkOnVmScope()
    }

    private suspend fun doWork() {
        context?.run {
            toast("Work started")
            delay(MainViewModel.WORK_DURATION)
            toast("Work ended")
        }
    }
}