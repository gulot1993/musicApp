package com.example.mymusic.core

import androidx.appcompat.app.AppCompatActivity
import com.example.mymusic.MyMusic
import com.example.mymusic.core.di.CoreComponent

open class BaseActivity: AppCompatActivity() {
    val app: MyMusic
        get() = application as MyMusic

    val coreComponent: CoreComponent
        get() = app.coreComponent!!

}