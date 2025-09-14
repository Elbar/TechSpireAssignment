package com.example.presentation.di

import com.example.domain.model.Point
import com.example.domain.repository.PointsRepository
import com.example.domain.usecase.GetPointsUseCase
import com.example.presentation.ui.main.MainViewModel
import com.example.presentation.ui.result.ResultViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// This module is used for UI test, see impl. in MainActivityTest and ResultActivity
val testAppModule = module {
    single<PointsRepository> {
        object : PointsRepository {
            override suspend fun getPoints(count: Int) = listOf(
                Point(1.0, 2.0),
                Point(3.0, 4.0)
            )
        }
    }
    single { GetPointsUseCase(get()) }
    viewModel { MainViewModel() }
    viewModel { ResultViewModel(get()) }
}