package br.com.zup.movieflix.moviedetail.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorModel
import br.com.zup.movieflix.moviedetail.repository.MovieDetailRepository

class DirectorViewModel (application: Application): AndroidViewModel(application) {
    private val repository  = MovieDetailRepository(DirectorLocalDataSource(application))
    private var _response : MutableLiveData<MovieWithDirectorModel> = MutableLiveData()
    val response : LiveData<MovieWithDirectorModel> = _response

    fun getMovieWithDirector(movie: Movie){
        try {
            _response.value = repository.getMovieWithDirector(movie)
        }catch (e:Exception){
            Log.e("Erro", e.message.toString())
        }

    }

    fun saveFavoriteMovie(movieName: String, isChecked: Boolean) {
        repository.saveFavoriteMovie(movieName, isChecked)
    }

    fun getFavoriteMovie(movieName: String) :Boolean {
       return repository.getFavoriteMovie(movieName)
    }
}