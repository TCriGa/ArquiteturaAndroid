package br.com.zup.minha__musica_favorita.detalhe.album.listaMusica

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.CHAVE_MUSICA
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityLetraMusicaBinding
import br.com.zup.minha__musica_favorita.model.Musica

class LetraMusicaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLetraMusicaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLetraMusicaBinding.inflate(layoutInflater)
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
        val intentMusica = intent.getParcelableExtra<Musica>(CHAVE_MUSICA)

        if (intentMusica != null) {
            receberInformacoes(intentMusica)
        }
    }

    fun receberInformacoes(musica: Musica) {
        binding.textLetraMusica.text = musica.getLetraMusica()
    }


}