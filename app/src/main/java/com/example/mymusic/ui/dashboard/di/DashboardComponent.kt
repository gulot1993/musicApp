package com.example.mymusic.ui.dashboard.di

import com.example.mymusic.core.di.CoreComponent
import com.example.mymusic.ui.dashboard.DashboardViewModel
import dagger.Component

@Component(dependencies = [CoreComponent::class])
@DashboardScope
interface DashboardComponent {
    fun inject(viewModel: DashboardViewModel)
}