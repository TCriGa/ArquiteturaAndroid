package br.com.zup.minha__musica_favorita.information.album.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.KEY_ALBUM
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityAlbumBinding
import br.com.zup.minha__musica_favorita.information.album.model.Album

class AlbumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlbumBinding.inflate(layoutInflater)

        exhibitAppBarCustomized()
        setContentView(binding.root)
        recuperateInformaticsAlbum()

        binding.imagemFavorito.setOnClickListener {
            Toast.makeText(this, getString(R.string.album_favorito), Toast.LENGTH_SHORT).show()
        }
    }

    private fun exhibitAppBarCustomized() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detalhe_banda)
    }

    private fun recuperateInformaticsAlbum() {
        val albumReceiver = intent.getParcelableExtra<Album>(KEY_ALBUM)

        if (albumReceiver != null) {
            getInformation(albumReceiver)
        }
    }

    private fun getInformation(album: Album) {
        binding.imageDetalhe.setImageResource(album.image)
        binding.textAno.text = album.yearProduct
        binding.textDescricao.text = album.describe
        binding.textNome.text = album.albumNome
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}