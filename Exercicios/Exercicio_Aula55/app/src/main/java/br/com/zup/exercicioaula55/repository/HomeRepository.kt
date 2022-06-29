package br.com.zup.exercicioaula55.repository

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class HomeRepository(application: Application) {
    companion object {
        const val KEY = "KEY_INFORMATION"
        const val LOGIN = "LOGIN"
        const val PASSWORD = "PASSWORD"
    }

    private val pref: SharedPreferences =
        application.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    private val prefEditor = pref.edit()

    fun saveFavoriteInformation(login: String, password: String) {
        prefEditor.putString(PASSWORD, password)
        prefEditor.putString(LOGIN, login)
        prefEditor.apply()
    }

    fun getPassword() = pref.getString(PASSWORD, "")

    fun getLogin() = pref.getString(LOGIN, "")


}