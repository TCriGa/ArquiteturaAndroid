package br.com.zup.minha__musica_favorita.informacoes.detalhe.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.minha__musica_favorita.informacoes.album.view.AlbumFragment
import br.com.zup.minha__musica_favorita.informacoes.musica.view.MusicaFragment
import br.com.zup.minha__musica_favorita.informacoes.detalhe.view.DetalheFragment

class DetalhePagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var listTitles: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listTitles.size

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return DetalheFragment()
            1 -> return AlbumFragment()
            2 ->return MusicaFragment()
        }

        return DetalheFragment()
    }
}