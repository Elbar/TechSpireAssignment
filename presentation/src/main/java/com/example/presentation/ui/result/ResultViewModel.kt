package com.example.presentation.ui.result

import androidx.lifecycle.ViewModel
import com.example.domain.model.Point

class ResultViewModel : ViewModel() {
    fun sortPoints(points: List<Point>): List<Point> = points.sortedBy { it.x }
}