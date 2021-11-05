package com.example.mymusic.ui.splash.di

import com.example.mymusic.core.di.CoreComponent
import com.example.mymusic.ui.splash.SplashViewModel
import dagger.Component

@SplashScope
@Component(dependencies = [CoreComponent::class])
interface SplashComponent {
    fun inject(viewModel: SplashViewModel)
}