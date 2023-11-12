package com.sergstas.androidpracticetasks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sergstas.androidpracticetasks.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fragmentIsVisible = false
        ActivityMainBinding.inflate(layoutInflater).run {
            setContentView(root)
            bShow.setOnClickListener {
                fragmentIsVisible = !fragmentIsVisible
                bShow.text =
                    if (fragmentIsVisible) "Hide fragment"
                    else "Show fragment"
                supportFragmentManager.beginTransaction().replace(
                    R.id.fcv_main,
                    if (fragmentIsVisible) MainFragment() else Fragment()
                ).commit()
            }
        }
    }
}