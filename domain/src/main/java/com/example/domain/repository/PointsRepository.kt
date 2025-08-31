package com.example.domain.repository

import com.example.domain.model.Point

interface PointsRepository {
    suspend fun getPoints(count: Int): List<Point>
}