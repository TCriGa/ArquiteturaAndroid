package br.com.zup.movieflix.moviedetail.repository

import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorModel

class MovieDetailRepository(val dataSource: DirectorLocalDataSource) {

    fun getMovieWithDirector(movie: Movie): MovieWithDirectorModel {
        val listDeDirectories = dataSource.directorList
        val director = listDeDirectories.first { it.directorName == movie.director }

        return MovieWithDirectorModel(director, movie)
    }

    fun saveFavoriteMovie(movieName: String, isChecked: Boolean) {
        dataSource.saveFavoriteMovie(movieName, isChecked)
    }

    fun getFavoriteMovie(movieName: String) : Boolean{
       return dataSource.getFavoriteMovie(movieName)
    }
}