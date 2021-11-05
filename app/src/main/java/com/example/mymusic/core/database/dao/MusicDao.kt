package com.example.mymusic.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mymusic.model.MusicEntity

@Dao
interface MusicDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(musics: List<MusicEntity>)

    @Query("Select * from music")
    suspend fun loadMusics(): List<MusicEntity>
}