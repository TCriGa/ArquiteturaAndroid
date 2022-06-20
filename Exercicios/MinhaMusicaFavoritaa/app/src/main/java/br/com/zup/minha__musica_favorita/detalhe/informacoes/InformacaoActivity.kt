package br.com.zup.minha__musica_favorita.detalhe.informacoes

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityInformacaoBinding
import br.com.zup.minha__musica_favorita.detalhe.informacoes.adapter.InformacoesPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class InformacaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformacaoBinding
    private val listaMusica = listOf("Informações","Fotos", "Música" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        exibirViewPagerTabLayout()


    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(getString(R.string.detalhe_banda))
    }

    private fun exibirViewPagerTabLayout(){
        val informacoesPagerAdapter = InformacoesPagerAdapter(supportFragmentManager, lifecycle, listaMusica)
        binding.viewInformacoes.adapter = informacoesPagerAdapter

        TabLayoutMediator(binding.TabInformacoes, binding.viewInformacoes){tab, posicao ->
            tab.text = listaMusica[posicao]
        }.attach()
    }

}