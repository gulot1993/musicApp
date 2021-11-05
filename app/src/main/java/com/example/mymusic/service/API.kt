package com.example.mymusic.service

import com.example.mymusic.core.model.BaseResponse
import com.example.mymusic.model.MusicDTO
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    suspend fun musics(): BaseResponse<List<MusicDTO>>
}