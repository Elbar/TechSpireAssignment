package com.example.presentation.ui.result

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Point
import com.example.presentation.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class ResultActivity : ComponentActivity() {

    private val viewModel = ResultViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val chart = findViewById<LineChart>(R.id.chart)

        val points = intent.getParcelableArrayListExtra<Point>("points") ?: arrayListOf()

        val sortedPoints = viewModel.sortPoints(points)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PointsAdapter(sortedPoints)

        val entries = sortedPoints.map { Entry(it.x.toFloat(), it.y.toFloat()) }
        val dataSet = LineDataSet(entries, "Points").apply {
            color = Color.BLUE
            setCircleColor(Color.RED)
            lineWidth = 2f
            circleRadius = 4f
            setDrawValues(false)
        }
        chart.data = LineData(dataSet)
        chart.invalidate()
    }
}
