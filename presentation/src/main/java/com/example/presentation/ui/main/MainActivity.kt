package com.example.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.presentation.R
import com.example.presentation.ui.result.ResultActivity
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by inject()

    private lateinit var etCount: EditText
    private lateinit var btnGo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCount = findViewById(R.id.etCount)
        btnGo = findViewById(R.id.btnGo)

        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest { state ->
                when (state) {
                    is MainUiState.Idle -> Unit
                    is MainUiState.Loading -> Toast.makeText(
                        this@MainActivity,
                        "Загрузка...",
                        Toast.LENGTH_SHORT
                    ).show()

                    is MainUiState.Error -> Toast.makeText(
                        this@MainActivity,
                        state.message,
                        Toast.LENGTH_SHORT
                    ).show()

                    is MainUiState.Success -> {
                        val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putParcelableArrayListExtra("points", ArrayList(state.points))
                        startActivity(intent)
                    }
                }
            }
        }


        btnGo.setOnClickListener {
            val count = etCount.text.toString().toIntOrNull()
            if (count == null || count <= 0) {
                Toast.makeText(this, "Введите корректное число", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.loadPoints(count)
            }
        }
    }
}
