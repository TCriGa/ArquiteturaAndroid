package br.com.zup.minha__musica_favorita.informacoes.detalhe.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityInformacaoBinding
import br.com.zup.minha__musica_favorita.informacoes.detalhe.view.adapter.DetalhePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetalheActivity : AppCompatActivity() {

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
        val detalhePagerAdapter = DetalhePagerAdapter(supportFragmentManager, lifecycle, listaMusica)
        binding.viewInformacoes.adapter = detalhePagerAdapter

        TabLayoutMediator(binding.TabInformacoes, binding.viewInformacoes){tab, posicao ->
            tab.text = listaMusica[posicao]
        }.attach()
    }

}