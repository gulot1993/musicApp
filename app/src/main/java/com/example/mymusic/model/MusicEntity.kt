package com.example.mymusic.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music")
data class MusicEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val imageURL: String,
    val price: Float,
    val genre: String,
    val description: String
)