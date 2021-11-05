package com.example.mymusic.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    abstract fun initiateInjection()
}