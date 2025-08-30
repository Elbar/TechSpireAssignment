package com.example.data.remote.dto

data class PointsResponse(
    val points: List<PointDto>
)

data class PointDto(
    val x: Double,
    val y: Double
)
