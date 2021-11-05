package com.example.mymusic.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymusic.core.BaseViewModel
import com.example.mymusic.core.di.CoreComponent
import com.example.mymusic.core.ui.Status
import com.example.mymusic.repository.MusicRepository
import com.example.mymusic.ui.splash.di.DaggerSplashComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel(val coreComponent: CoreComponent): BaseViewModel() {

    @Inject
    lateinit var repository: MusicRepository

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    init {
        initiateInjection()
    }

    fun musics() {
        viewModelScope.launch {
            try {
                repository.musics()
                // added delay to ensure that every action taken is done
                delay(1500)
                _status.value = SplashStatus.NavigateToDashboard
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    override fun initiateInjection() {
        DaggerSplashComponent.builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this@SplashViewModel)
    }
}