package com.example.domain.di

import com.example.domain.usecase.GetPointsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetPointsUseCase(get()) }
}
