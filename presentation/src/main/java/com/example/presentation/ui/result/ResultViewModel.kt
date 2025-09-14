package com.example.presentation.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PointsResult
import com.example.domain.usecase.GetPointsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResultViewModel(
    private val getPointsUseCase: GetPointsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ResultUiState())
    val uiState: StateFlow<ResultUiState> = _uiState

    fun loadPoints(count: Int) {
        viewModelScope.launch {
            _uiState.value = ResultUiState(loading = true)
            when (val result = getPointsUseCase(count)) {
                is PointsResult.Success -> {
                    _uiState.value = ResultUiState(points = result.points)
                }
                is PointsResult.Error -> {
                    _uiState.value = ResultUiState(error = result.message)
                }
            }
        }
    }
}