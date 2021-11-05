package com.example.mymusic.model

import com.example.mymusic.core.model.Model


data class Music(
    val name: String,
    val description: String,
    val price: String,
    val imageURL: String,
    val genre: String,
): Model