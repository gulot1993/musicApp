package com.example.mymusic.core

import androidx.fragment.app.Fragment
import com.example.mymusic.MainActivity
import com.example.mymusic.core.di.CoreComponent

open class BaseFragment: Fragment() {
   val coreComponent: CoreComponent
    get() = (requireActivity() as MainActivity).coreComponent

}