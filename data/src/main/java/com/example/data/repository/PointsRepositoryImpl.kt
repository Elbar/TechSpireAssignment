package com.example.data.repository

import com.example.data.remote.TechSpireApi
import com.example.domain.model.Point
import com.example.domain.repository.PointsRepository

class PointsRepositoryImpl(private val api: TechSpireApi) : PointsRepository {
    override suspend fun getPoints(count: Int): List<Point> {
        val response = api.getPoints(count)
        return response.points.map { Point(it.x, it.y) }
    }
}