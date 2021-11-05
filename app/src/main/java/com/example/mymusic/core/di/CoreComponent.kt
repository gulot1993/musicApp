package com.example.mymusic.core.di

import android.content.Context
import com.example.mymusic.core.PreferenceHelper
import com.example.mymusic.core.database.db.MyMusicDatabase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    fun context(): Context
    fun provideDatabase(): MyMusicDatabase
    fun providePreferenceHelper(): PreferenceHelper
}