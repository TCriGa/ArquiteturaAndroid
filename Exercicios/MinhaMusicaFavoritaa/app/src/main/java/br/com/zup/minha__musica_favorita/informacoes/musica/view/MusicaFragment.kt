package br.com.zup.minha__musica_favorita.informacoes.musica.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.minha__musica_favorita.*
import br.com.zup.minha__musica_favorita.databinding.FragmentMusicaBinding
import br.com.zup.minha__musica_favorita.informacoes.musica.model.Music
import br.com.zup.minha__musica_favorita.informacoes.musica.view.adapter.MusicaAdapter

class MusicaFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentMusicaBinding

    private val musicaAdapter: MusicaAdapter by lazy {
        MusicaAdapter(arrayListOf(), this :: irParaLetraMusica)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adicionarListaMusica()
    }

    private fun exibirRecycleView() {
        binding.rvListaMusica.adapter = musicaAdapter
        binding.rvListaMusica.layoutManager = LinearLayoutManager(this.context)
    }

    private fun adicionarListaMusica() {



        musicaAdapter.atualizarListaMusica(listaMusic)
        exibirRecycleView()
    }

    private fun irParaLetraMusica(music: Music){
        val intent = Intent(this.context, MusicaActivity :: class.java).apply {
           putExtra(CHAVE_MUSICA, music)
        }

        startActivity(intent)

    }


}