package com.example.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetPointsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPointsUseCase: GetPointsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MainUiState>(MainUiState.Idle)
    val state: StateFlow<MainUiState> = _state

    fun loadPoints(count: Int) {
        viewModelScope.launch {
            _state.value = MainUiState.Loading
            try {
                val points = getPointsUseCase(count)
                _state.value = MainUiState.Success(points)
            } catch (e: Exception) {
                _state.value = MainUiState.Error(e.message ?: "Ошибка")
            }
        }
    }
}
