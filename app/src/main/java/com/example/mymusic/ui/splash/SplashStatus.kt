package com.example.mymusic.ui.splash

import com.example.mymusic.core.ui.Status

sealed class SplashStatus: Status() {
    object NavigateToDashboard: SplashStatus()
}