package br.com.zup.movieflix.moviedetail.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.CHAVE_MOVIE
import br.com.zup.movieflix.databinding.ActivityMovieDetailBinding
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.viewmodel.DirectorViewModel

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    private val viewModel: DirectorViewModel by lazy {
        ViewModelProvider(this)[DirectorViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPassedData()
        observable()
    }

    private fun getPassedData() {
        val movie = intent.getParcelableExtra<Movie>(CHAVE_MOVIE)
        movie?.let { viewModel.getMovieWithDirector(it) }
    }

    private fun observable() {
        viewModel.response.observe(this) {

            binding.tvMovieTitle.text = it.movie.title
            binding.tvDirectorName.text = it.director.directorName
            binding.tvMovieSinopse.text = it.movie.synopses
            binding.imageView.setImageResource(it.movie.image)
            binding.tvDirectorInfo.text = it.director.directorInfo

            binding.switchFavoritar.isChecked =
                viewModel.getFavoriteMovie(it.movie.title)

            binding.switchFavoritar.setOnCheckedChangeListener { _, isChecked ->
                viewModel.saveFavoriteMovie(it.movie.title, isChecked)
            }
        }


    }
}
