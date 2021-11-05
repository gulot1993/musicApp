package com.example.mymusic.repository

import com.example.mymusic.core.PreferenceHelper
import com.example.mymusic.core.database.db.MyMusicDatabase
import com.example.mymusic.core.network.NetworkModule
import com.example.mymusic.core.toMusic
import com.example.mymusic.core.toMusicEntity
import com.example.mymusic.model.Music
import com.example.mymusic.model.MusicDTO
import com.example.mymusic.service.API
import timber.log.Timber
import javax.inject.Inject

class MusicRepository @Inject constructor() {
    @Inject
    lateinit var db: MyMusicDatabase

    val api: API
        get() = NetworkModule.getInstance().provideApi()

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    var lastVisited: String?
        set(value) {  preferenceHelper.lastVisited = value }
        get() = preferenceHelper.lastVisited

    /**
     * get music list from network then save to room db
     * */
    suspend fun musics() {
        try {
            val response = api.musics()
            val musics = response.results
            val musicsWithTrackName = musics.map{ it.toMusicEntity() }
            db.musicDao().insert(musicsWithTrackName)
        } catch (e: Throwable) {
            throw e
        }
    }

    /**
     * load music from db
     * */
    suspend fun loadMusics(): List<Music>{
        try {
            val musics = db.musicDao().loadMusics()
            return musics.map { it.toMusic() }.sortedBy { it.name }
        } catch (e: Throwable) {
            throw e
        }
    }
}