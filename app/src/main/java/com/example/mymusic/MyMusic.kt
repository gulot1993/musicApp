package com.example.mymusic

import android.app.Application
import com.example.mymusic.core.di.CoreComponent
import com.example.mymusic.core.di.CoreModule
import com.example.mymusic.core.di.DaggerCoreComponent
import com.facebook.drawee.backends.pipeline.Fresco
import timber.log.Timber

class MyMusic: Application() {
    var coreComponent: CoreComponent? = null
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Timber.plant(Timber.DebugTree())

        coreComponent = DaggerCoreComponent.builder()
                .coreModule(CoreModule(this))
                .build()
    }
}