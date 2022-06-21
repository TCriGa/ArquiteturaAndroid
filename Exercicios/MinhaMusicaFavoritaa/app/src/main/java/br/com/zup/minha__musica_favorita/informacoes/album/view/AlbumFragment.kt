package br.com.zup.minha__musica_favorita.informacoes.album.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minha__musica_favorita.*
import br.com.zup.minha__musica_favorita.databinding.FragmentAlbumBinding
import br.com.zup.minha__musica_favorita.informacoes.album.model.Album
import br.com.zup.minha__musica_favorita.informacoes.album.view.adapter.AlbumMusicaAdapter
import br.com.zup.minha__musica_favorita.informacoes.album.viewmodel.AlbumViewModel

class AlbumFragment : Fragment() {

    private lateinit var binding: FragmentAlbumBinding

    private val albumAdapter: AlbumMusicaAdapter by lazy {
        AlbumMusicaAdapter(arrayListOf(), this::irParaDetalheClickFragment)
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
        exibirRecyclerView()

    }

    private fun exibirRecyclerView() {
        binding.rvListaAlbum.adapter = albumAdapter
        binding.rvListaAlbum.layoutManager = GridLayoutManager(context, 2)
        observable()
        viewModel.getAllAlbum()
    }

    private fun observable() {
        viewModel.album.observe(this.viewLifecycleOwner) {
            albumAdapter.listaAlbum.addAll(it)
        }
    }


    private fun irParaDetalheClickFragment(album: Album) {

        val intent = Intent(this.context, AlbumActivity::class.java).apply {
            putExtra(CHAVE_ALBUM, album)
        }

        startActivity(intent)
    }
}





