package com.example.domain.model


sealed class PointsResult {
    data class Success(val points: List<Point>) : PointsResult()
    data class Error(val message: String) : PointsResult()
}