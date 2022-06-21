package br.com.zup.minha__musica_favorita.information.music.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.KEY_MUSIC
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityMusicBinding
import br.com.zup.minha__musica_favorita.information.music.model.Music

class MusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMusicBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        exhibitAppBarCustomized()
        getIntentMusic()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun exhibitAppBarCustomized() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detalhe_banda)
    }

    private fun getIntentMusic() {
        val intentMusic = intent.getParcelableExtra<Music>(KEY_MUSIC)

        if (intentMusic != null) {
            getBindingMusic(intentMusic)
        }
    }

    private fun getBindingMusic(music: Music) {
        binding.textLetraMusica.text = music.letterMusic
    }
}