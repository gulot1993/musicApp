package com.example.mymusic.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymusic.core.BaseViewModel
import com.example.mymusic.core.di.CoreComponent
import com.example.mymusic.model.Music
import com.example.mymusic.repository.MusicRepository
import com.example.mymusic.ui.dashboard.di.DaggerDashboardComponent
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class DashboardViewModel(val coreComponent: CoreComponent): BaseViewModel() {
    @Inject
    lateinit var repository: MusicRepository

    private val _musics = MutableLiveData<List<Music>>()
    val musics: LiveData<List<Music>>
        get() = _musics

    var lastVisited: String?
        get() = repository.lastVisited
        set(value) { repository.lastVisited = value }

    init {
        initiateInjection()
    }

    override fun initiateInjection() {
        DaggerDashboardComponent.builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this@DashboardViewModel)
    }

    fun loadMusics() {
        viewModelScope.launch {
            try {
                val musics = repository.loadMusics()
                _musics.value = musics
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}