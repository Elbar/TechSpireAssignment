package com.example.domain

import com.example.domain.model.Point
import com.example.domain.repository.PointsRepository
import com.example.domain.usecase.GetPointsUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetPointsUseCaseTest {

    private lateinit var repository: PointsRepository
    private lateinit var useCase: GetPointsUseCase

    @Before
    fun setup() {
        repository = mock()
        useCase = GetPointsUseCase(repository)
    }

    @Test
    fun `throws exception if count is zero`() {
        assertThrows(IllegalArgumentException::class.java) {
            runTest { useCase(0) }
        }
    }

    @Test
    fun `returns sorted points`() = runTest {
        val points = listOf(Point(5.0, 1.0), Point(1.0, 2.0))
        whenever(repository.getPoints(2)).thenReturn(points)

        val result = useCase(2)

        assertEquals(listOf(Point(1.0, 2.0), Point(5.0, 1.0)), result)
    }
}
