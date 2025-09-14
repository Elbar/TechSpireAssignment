package com.example.presentation.ui.result

import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Point
import com.example.presentation.databinding.ActivityResultBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import org.koin.android.ext.android.inject

class ResultActivity : ComponentActivity() {

    private val viewModel: ResultViewModel by inject()
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val count = intent.getIntExtra("count", 0)
        viewModel.loadPoints(count)

        lifecycleScope.launchWhenStarted {
                viewModel.uiState.collect { state ->
                    renderState(state, count)
                }
        }

        binding.btnSave.setOnClickListener {
            saveChartToFile(binding.chart)
        }
    }

    private fun renderState(state: ResultUiState, count: Int) {
        binding.progressBar.isVisible = state.loading
        binding.errorGroup.isVisible = state.error != null
        binding.contentGroup.isVisible = state.points.isNotEmpty()

        when {
            state.loading -> {
                    // skip as progress bar loading
                 }
            state.error != null -> {
                binding.errorText.text = state.error
                binding.retryButton.setOnClickListener {
                    viewModel.loadPoints(count)
                }
            }
            state.points.isNotEmpty() -> {
                updateRecycler(state.points)
                updateChart(state.points)
            }
        }
    }

    private fun updateRecycler(points: List<Point>) {
        val adapter = PointsAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.submitList(points)
    }

    private fun updateChart(points: List<Point>) {
        val entries = points
            .mapNotNull {
                val x = it.x.toFloat()
                val y = it.y.toFloat()
                if (x.isFinite() && y.isFinite()) Entry(x, y) else null
            }
            .sortedBy { it.x }

        if (entries.isEmpty()) {
            binding.chart.clear()
            return
        }

        val dataSet = LineDataSet(entries, "Points").apply {
            color = Color.BLUE
            setCircleColor(Color.RED)
            lineWidth = 2f
            circleRadius = 4f
            setDrawValues(false)
        }
        binding.chart.data = LineData(dataSet)
        binding.chart.invalidate()
    }

    private fun saveChartToFile(chart: LineChart) {
        val bitmap = chart.chartBitmap
        val filename = "graph_${System.currentTimeMillis()}.png"
        val resolver = contentResolver
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/Graphs")
        }
        val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        uri?.let {
            resolver.openOutputStream(it).use { out ->
                if (out != null) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                }
            }
            Toast.makeText(this, "График сохранён", Toast.LENGTH_SHORT).show()
        }
    }
}
