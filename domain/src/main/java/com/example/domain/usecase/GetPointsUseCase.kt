package com.example.domain.usecase

import com.example.domain.model.Point
import com.example.domain.repository.PointsRepository

class GetPointsUseCase(
    private val repository: PointsRepository
) {
    suspend operator fun invoke(count: Int): List<Point> {
        require(count > 0) { "Количество точек должно быть > 0" }
        return repository.getPoints(count).sortedBy { it.x }
    }
}