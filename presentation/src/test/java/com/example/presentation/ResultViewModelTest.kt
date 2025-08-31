package com.example.presentation

import com.example.domain.model.Point
import com.example.presentation.ui.result.ResultViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ResultViewModelTest {

    private val viewModel = ResultViewModel()

    @Test
    fun `sortPoints returns points sorted by x`() {
        val points = listOf(Point(10.0, 2.0), Point(1.0, 5.0))
        val result = viewModel.sortPoints(points)

        assertEquals(listOf(Point(1.0, 5.0), Point(10.0, 2.0)), result)
    }
}
