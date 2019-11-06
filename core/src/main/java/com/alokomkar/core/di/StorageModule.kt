package com.alokomkar.core.di

import android.content.Context
import android.content.SharedPreferences
import com.alokomkar.core.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Suppress("PrivatePropertyName")
    private val SHARED_PREFERENCES = "${BuildConfig.LIBRARY_PACKAGE_NAME}.spacex.prefs"

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }
}