package br.com.zup.minha__musica_favorita.information.music.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.minha__musica_favorita.KEY_MUSIC
import br.com.zup.minha__musica_favorita.databinding.FragmentMusicBinding
import br.com.zup.minha__musica_favorita.information.music.model.Music
import br.com.zup.minha__musica_favorita.information.music.view.adapter.MusicAdapter
import br.com.zup.minha__musica_favorita.information.music.viewmodel.MusicViewModel

class MusicFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentMusicBinding
    private val viewModel: MusicViewModel by lazy {
        ViewModelProvider(this)[MusicViewModel::class.java]
    }

    private val musicAdapter: MusicAdapter by lazy {
        MusicAdapter(arrayListOf(), this::irParaLetraMusica)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exhibitRecycleView()
    }

    private fun exhibitRecycleView() {
        binding.rvListaMusica.adapter = musicAdapter
        binding.rvListaMusica.layoutManager = LinearLayoutManager(this.context)
        observables()
        viewModel.getAllListMusic()
    }

    private fun observables() {
        viewModel.response.observe(this.viewLifecycleOwner) {
            musicAdapter.listAlbum.addAll(it)
        }
    }

    private fun irParaLetraMusica(music: Music) {
        val intent = Intent(this.context, MusicActivity::class.java).apply {
            putExtra(KEY_MUSIC, music)
        }
        startActivity(intent)
    }
}