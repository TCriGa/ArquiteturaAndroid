package br.com.zup.movieflix.moviedetail.datasource

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import br.com.zup.movieflix.*
import br.com.zup.movieflix.moviedetail.model.DirectorModel

class DirectorLocalDataSource(private val application: Application) {

    private val pref: SharedPreferences =
        application.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    private val prefEditor = pref.edit()

    fun saveFavoriteMovie(movieName: String, checked: Boolean) {
        prefEditor.putBoolean(movieName, checked)
        prefEditor.apply()
    }

    val directorList = mutableListOf(
        DirectorModel(
            TARANTINO,
            TARANTINO_INFO
        ),
        DirectorModel(
            MARTIN_SCORSESE,
            MARTIN_SCORSESE_INFO
        )
    )

    fun getFavoriteMovie(movieName: String): Boolean {
        return pref.getBoolean(movieName, false)
    }
}