package com.example.mymusic.core.model

import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class BaseResponse<T>(
    val resultCount: Int,
    val results: @RawValue T
): Model