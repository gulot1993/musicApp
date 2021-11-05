package com.example.mymusic.core.di

import android.content.Context
import com.example.mymusic.core.PreferenceHelper
import com.example.mymusic.core.database.db.MyMusicDatabase
import com.example.mymusic.repository.MusicRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(val context: Context) {
    @Provides
    fun provideContext(): Context = context

    @Singleton
    @Provides
    fun provideMusicRepository(musicRepository: MusicRepository): MusicRepository = musicRepository

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MyMusicDatabase = MyMusicDatabase.getInstance(context)

    @Singleton
    @Provides
    fun providePreferenceHelper(): PreferenceHelper = PreferenceHelper.getInstance(context)
}