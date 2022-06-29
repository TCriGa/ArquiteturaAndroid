package br.com.zup.exercicioaula55.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.zup.exercicioaula55.repository.HomeRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HomeRepository(application)


    fun saveInformation(login: String, password: String) {
        repository.saveFavoriteInformation(login, password)
    }

    fun getLogin() = repository.getLogin()
    fun getPassoword() = repository.getPassword()

}