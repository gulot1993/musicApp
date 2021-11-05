package com.example.mymusic.model

import com.example.mymusic.core.model.Model
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MusicDTO(
    @SerializedName("trackId") val id: String?,
    @SerializedName("trackName") val name: String?,
    @SerializedName("artworkUrl100") val imageURL: String,
    @SerializedName("trackPrice") val price: Float,
    @SerializedName("primaryGenreName") val genre: String,
    @SerializedName("longDescription") val description: String?
): Model