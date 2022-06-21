package br.com.zup.minha__musica_favorita.information.music.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.minha__musica_favorita.information.music.model.Music
import br.com.zup.minha__musica_favorita.information.music.repository.MusicRepository

class MusicViewModel : ViewModel() {

    private val repository = MusicRepository()
    private val _response: MutableLiveData<List<Music>> = MutableLiveData()
    val response: LiveData<List<Music>> = _response

    fun getAllListMusic() {
        try {
            _response.value = repository.getListMusic()
        } catch (ex: Exception) {
            Log.i("Error", "----->${ex.message}")
        }
    }
}