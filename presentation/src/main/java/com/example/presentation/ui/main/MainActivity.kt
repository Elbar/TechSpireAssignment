package com.example.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.ui.result.ResultActivity

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            val count = binding.etCount.text.toString().toIntOrNull() ?: return@setOnClickListener
            startActivity(Intent(this, ResultActivity::class.java).apply {
                putExtra("count", count)
            })
        }
    }
}
