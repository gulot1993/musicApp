package com.example.mymusic.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferenceHelper(val sharedPreferences: SharedPreferences) {

    companion object {
        private var INSTANCE: PreferenceHelper? = null
        const val LAST_VISITED = "last_visited"

        fun getInstance(context: Context): PreferenceHelper {
            if (INSTANCE == null) {
                INSTANCE = PreferenceHelper(context.getSharedPreferences(
                    "my_music",
                    Context.MODE_PRIVATE
                ))
            }
            return INSTANCE!!
        }
    }

    fun setString(key: String, value: String?) {
        sharedPreferences.edit { putString(key, value) }
    }

    fun getString(key: String): String? = sharedPreferences.getString(key, null)

    var lastVisited: String?
        set(value) = setString(LAST_VISITED, value)
        get() = getString(LAST_VISITED)
}