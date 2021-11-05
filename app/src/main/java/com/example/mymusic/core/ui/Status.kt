package com.example.mymusic.core.ui

import androidx.annotation.StringRes

open class Status {
    data class Error(
        val message: String? = null,
        @StringRes val stringRes: Int? = null,
        val error: Throwable? = null
    ): Status()

    data class Loading(
        val show: Boolean = false,
    ): Status()
}