package com.example.mymusic.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymusic.core.di.CoreComponent
import com.example.mymusic.ui.dashboard.DashboardViewModel
import com.example.mymusic.ui.splash.SplashViewModel

class ViewModelFactory(val coreComponent: CoreComponent): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(coreComponent) as T
        } else if(modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(coreComponent) as T
        } else {
            throw IllegalArgumentException("unknown viewmodel")
        }
    }
}