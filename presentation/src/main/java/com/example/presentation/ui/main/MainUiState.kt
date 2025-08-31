package com.example.presentation.ui.main

import com.example.domain.model.Point

sealed class MainUiState {
    data object Idle : MainUiState()
    data object Loading : MainUiState()
    data class Success(val points: List<Point>) : MainUiState()
    data class Error(val message: String) : MainUiState()
}