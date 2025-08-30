package com.example.techspireassignment

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

class TechSpireApp : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TechSpireApp)
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    presentationModule
                )
            )
        }
    }
}