package com.example.mymusic.core.database.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.mymusic.core.database.dao.MusicDao
import com.example.mymusic.model.MusicEntity

@Database(entities = [MusicEntity::class], version = 1, exportSchema = false)
abstract class MyMusicDatabase: RoomDatabase() {

    abstract fun musicDao(): MusicDao

    companion object {
        private var INSTANCE: MyMusicDatabase? = null

        fun getInstance(context: Context): MyMusicDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                INSTANCE = Room.databaseBuilder(context, MyMusicDatabase::class.java, "my_music_db").build()
                return INSTANCE!!
            }
        }
    }
}