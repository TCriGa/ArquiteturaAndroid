package br.com.zup.exercicioaula55.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.exercicioaula55.model.HomeModel
import br.com.zup.exercicioaula55.repository.HomeRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HomeRepository(application)
    private var _response : MutableLiveData<HomeModel> = MutableLiveData()
    val response : LiveData<HomeModel> = _response


    fun saveInformation(information: String, isChecked: Boolean) {
        repository.saveFavoriteInformation(information, isChecked)
    }

    fun getFavoriteInformation(information: String) :Boolean {
        return repository.getFavoriteInformation(information)
    }

}