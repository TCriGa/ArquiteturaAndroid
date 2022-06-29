package br.com.zup.minha__musica_favorita.information.album.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.minha__musica_favorita.information.album.model.Album
import br.com.zup.minha__musica_favorita.information.album.repository.AlbumRepository

class AlbumViewModel() : ViewModel() {

    private val repository = AlbumRepository()
    private val _response: MutableLiveData<List<Album>> = MutableLiveData()
    val response: LiveData<List<Album>> = _response

    fun getAllAlbum() {
        try {
            _response.value = repository.getAlbumList()
        } catch (ex: Exception) {
            Log.i("Error", "------> ${ex.message}")
        }
    }
}