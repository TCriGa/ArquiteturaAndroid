package br.com.zup.minha__musica_favorita.detalhe.informacoes.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.minha__musica_favorita.detalhe.album.FotosFragment
import br.com.zup.minha__musica_favorita.detalhe.album.listaMusica.ListaMusicaFragment
import br.com.zup.minha__musica_favorita.detalhe.informacoes.InformacoesFragment

class InformacoesPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var listaTitulos: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listaTitulos.size

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return InformacoesFragment()
            1 -> return FotosFragment()
            2 ->return ListaMusicaFragment()
        }

        return InformacoesFragment()
    }
}