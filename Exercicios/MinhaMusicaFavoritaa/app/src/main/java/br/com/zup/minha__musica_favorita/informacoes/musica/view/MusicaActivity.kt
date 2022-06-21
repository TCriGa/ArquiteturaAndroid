package br.com.zup.minha__musica_favorita.informacoes.musica.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.CHAVE_MUSICA
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityMusicaBinding
import br.com.zup.minha__musica_favorita.informacoes.musica.model.Music

class MusicaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMusicaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        receberInformacao()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(getString(R.string.detalhe_banda))
    }

    fun receberInformacao() {
        val intentMusic = intent.getParcelableExtra<Music>(CHAVE_MUSICA)

        if (intentMusic != null) {
            receberInformacoes(intentMusic)
        }
    }

    fun receberInformacoes(music: Music) {
        binding.textLetraMusica.text = music.letterMusic
    }


}