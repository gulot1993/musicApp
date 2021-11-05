package com.example.mymusic.core.network

import com.example.mymusic.service.API
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModule {

    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .build()
    }

    fun retrofit(): Retrofit {
        val client = provideHttpClient()
        val gson = GsonBuilder()
                .setLenient()
                .create()
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()
    }

    fun provideApi(): API = retrofit().create(API::class.java)

    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
        private var INSTANCE: NetworkModule? = null

        fun getInstance(): NetworkModule = INSTANCE ?: NetworkModule()
    }
}