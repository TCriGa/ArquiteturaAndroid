package br.com.zup.minha__musica_favorita.information.detail.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.minha__musica_favorita.R
import br.com.zup.minha__musica_favorita.databinding.ActivityDetailBinding
import br.com.zup.minha__musica_favorita.information.detail.view.adapter.DetailPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val musicList = listOf("Informações","Fotos", "Música" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exhibitAppBarCustomized()
        exhibitViewPagerTabLayout()


    }

    private fun exhibitAppBarCustomized() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detalhe_banda)
    }

    private fun exhibitViewPagerTabLayout(){
        val detailPagerAdapter = DetailPagerAdapter(supportFragmentManager, lifecycle, musicList)
        binding.viewInformacoes.adapter = detailPagerAdapter

        TabLayoutMediator(binding.TabInformacoes, binding.viewInformacoes){tab, posicao ->
            tab.text = musicList[posicao]
        }.attach()
    }

}