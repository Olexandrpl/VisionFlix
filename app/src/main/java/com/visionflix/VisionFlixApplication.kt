package com.visionflix

import android.app.Application
import com.visionflix.di.apiModule
import com.visionflix.di.appModule
import com.visionflix.di.networkModule
import com.visionflix.di.repositoryModule
import com.visionflix.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VisionFlixApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VisionFlixApplication)
            modules(
                appModule,
                apiModule,
                repositoryModule,
                useCaseModule,
                networkModule
            )
        }
    }
}