package com.example.domain.usecase

import com.example.domain.model.PointsResult
import com.example.domain.repository.PointsRepository

class GetPointsUseCase(
    private val repository: PointsRepository
) {
    suspend operator fun invoke(count: Int): PointsResult {
        return try {
            val points = repository.getPoints(count)
            PointsResult.Success(points)
        } catch (e: Exception) {
            PointsResult.Error(e.message ?: "Unknown error")
        }
    }
}