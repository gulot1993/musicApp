package com.example.mymusic.core

import com.example.mymusic.model.Music
import com.example.mymusic.model.MusicDTO
import com.example.mymusic.model.MusicEntity

fun MusicDTO.toMusicEntity(): MusicEntity {
    return MusicEntity(
        id = if (id != null) id.toLong() else 0L,
        name = name ?: "",
        imageURL = imageURL,
        price = price,
        genre = genre,
        description = description ?: ""
    )
}

fun MusicEntity.toMusic(): Music {
    return Music(
        name = name,
        imageURL = imageURL,
        price = price.toString(),
        genre = genre,
        description = description
    )
}