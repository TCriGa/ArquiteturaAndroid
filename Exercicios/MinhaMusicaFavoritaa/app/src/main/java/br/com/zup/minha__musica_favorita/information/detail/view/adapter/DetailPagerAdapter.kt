package br.com.zup.minha__musica_favorita.information.detail.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.minha__musica_favorita.information.album.view.AlbumFragment
import br.com.zup.minha__musica_favorita.information.music.view.MusicFragment
import br.com.zup.minha__musica_favorita.information.detail.view.DetailFragment

class DetailPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var listTitles: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listTitles.size

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return DetailFragment()
            1 -> return AlbumFragment()
            2 ->return MusicFragment()
        }

        return DetailFragment()
    }
}