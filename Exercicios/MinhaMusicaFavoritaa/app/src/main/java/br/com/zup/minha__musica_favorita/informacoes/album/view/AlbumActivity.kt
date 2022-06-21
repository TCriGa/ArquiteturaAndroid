package br.com.zup.minha__musica_favorita.informacoes.album.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.minha__musica_favorita.CHAVE_ALBUM
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityAlbumBinding
import br.com.zup.minha__musica_favorita.informacoes.album.model.Album
import br.com.zup.minha__musica_favorita.informacoes.album.viewmodel.AlbumViewModel

class AlbumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlbumBinding.inflate(layoutInflater)

        exibirAppBarCustomizada()
        setContentView(binding.root)
        recuperarInformacoesAlbum()

        binding.imagemFavorito.setOnClickListener {
            Toast.makeText(this, getString(R.string.album_favorito), Toast.LENGTH_SHORT).show()
        }
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(getString(R.string.detalhe_banda))
    }


    fun recuperarInformacoesAlbum() {
        val albumReceber = intent.getParcelableExtra<Album>(CHAVE_ALBUM)

        if (albumReceber != null) {
            receberInformacoes(albumReceber)
        }
    }

    fun receberInformacoes(album: Album) {
        binding.imageDetalhe.setImageResource(album.imagem)
        binding.textAno.text = album.anoProducao
        binding.textDescricao.text = album.descricao
        binding.textNome.text = album.nomeAlbum
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}