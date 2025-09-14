package com.example.presentation.ui.result

import com.example.domain.model.Point

data class ResultUiState(
    val loading: Boolean = false,
    val points: List<Point> = emptyList(),
    val error: String? = null
)