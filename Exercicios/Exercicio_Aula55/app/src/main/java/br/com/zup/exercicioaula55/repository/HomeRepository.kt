package br.com.zup.exercicioaula55.repository

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class HomeRepository(private val application: Application) {
    companion object {
        const val KEY = "KEY_INFORMATION"
    }

    private val pref: SharedPreferences =
        application.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    private val prefEditor = pref.edit()

    fun saveFavoriteInformation(information: String, checked: Boolean) {
        prefEditor.putBoolean(information, checked)
        prefEditor.apply()
    }

    fun getFavoriteInformation(movieName: String): Boolean {
        return pref.getBoolean(movieName, false)
    }

}