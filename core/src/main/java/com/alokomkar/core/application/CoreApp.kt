package com.alokomkar.core.application

import android.app.Application
import com.alokomkar.core.BuildConfig
import com.alokomkar.core.di.AppModule
import com.alokomkar.core.di.CoreComponent
import com.alokomkar.core.di.DaggerCoreComponent
import com.facebook.stetho.Stetho

open class CoreApp : Application() {

    companion object {
        lateinit var coreComponent: CoreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDI()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initDI() {
        coreComponent = DaggerCoreComponent.builder().appModule(AppModule(this)).build()
    }
}