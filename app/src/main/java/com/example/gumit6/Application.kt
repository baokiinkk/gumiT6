package com.example.gumit6

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.gumit6.di.HomeViewmodelDi
import com.example.gumit6.di.RepositoryDi
import com.example.gumit6.di.appdaoModule
import com.example.gumit6.di.useCaseDi

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(
                RepositoryDi,
                appdaoModule,
                HomeViewmodelDi,
                useCaseDi
            ))
        }
    }

}