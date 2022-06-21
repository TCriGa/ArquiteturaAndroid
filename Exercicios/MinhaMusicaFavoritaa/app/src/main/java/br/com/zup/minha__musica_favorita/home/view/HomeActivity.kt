package br.com.zup.minha__musica_favorita.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityHomeBinding
import br.com.zup.minha__musica_favorita.information.detail.view.DetailActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.musica_favorita)

        binding.buttonDetalhe.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }


    }
}