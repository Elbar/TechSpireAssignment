package com.example.data.di

import com.example.data.remote.TechSpireApiRetrofitBuilder
import com.example.data.repository.PointsRepositoryImpl
import com.example.domain.repository.PointsRepository
import com.example.domain.usecase.GetPointsUseCase
import org.koin.dsl.module

val dataModule = module {
    single { TechSpireApiRetrofitBuilder.build() }
    factory { GetPointsUseCase(get()) }
    single<PointsRepository> { PointsRepositoryImpl(get())}
}
