package com.example.data.di

import com.example.data.remote.TechSpireApiRetrofitBuilder
import org.koin.dsl.module

val dataModule = module {
    single { TechSpireApiRetrofitBuilder.build() }

}
