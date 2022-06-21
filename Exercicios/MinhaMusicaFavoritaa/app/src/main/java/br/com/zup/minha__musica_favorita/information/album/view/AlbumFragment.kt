package br.com.zup.minha__musica_favorita.information.album.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minha__musica_favorita.KEY_ALBUM
import br.com.zup.minha__musica_favorita.databinding.FragmentAlbumBinding
import br.com.zup.minha__musica_favorita.information.album.model.Album
import br.com.zup.minha__musica_favorita.information.album.view.adapter.AlbumAdapter
import br.com.zup.minha__musica_favorita.information.album.viewmodel.AlbumViewModel

class AlbumFragment : Fragment() {

    private lateinit var binding: FragmentAlbumBinding

    private val albumAdapter: AlbumAdapter by lazy {
        AlbumAdapter(arrayListOf(), this::goToDetailClickFragment)
    }

    private val viewModel: AlbumViewModel by lazy {
        ViewModelProvider(this)[AlbumViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exhibitRecyclerView()

    }

    private fun exhibitRecyclerView() {
        binding.rvListaAlbum.adapter = albumAdapter
        binding.rvListaAlbum.layoutManager = GridLayoutManager(context, 2)
        observable()
        viewModel.getAllAlbum()
    }

    private fun observable() {
        viewModel.album.observe(this.viewLifecycleOwner) {
            albumAdapter.AlbumList.addAll(it)
        }
    }

    private fun goToDetailClickFragment(album: Album) {

        val intent = Intent(this.context, AlbumActivity::class.java).apply {
            putExtra(KEY_ALBUM, album)
        }

        startActivity(intent)
    }
}





