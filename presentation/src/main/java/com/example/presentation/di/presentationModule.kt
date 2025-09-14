package com.example.presentation.di

import com.example.presentation.ui.main.MainViewModel
import com.example.presentation.ui.result.ResultViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel() }
    viewModel { ResultViewModel(get()) }
}
