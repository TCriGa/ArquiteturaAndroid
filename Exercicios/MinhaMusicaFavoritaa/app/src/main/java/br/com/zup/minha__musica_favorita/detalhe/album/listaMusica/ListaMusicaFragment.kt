package br.com.zup.minha__musica_favorita.detalhe.album.listaMusica

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.minha__musica_favorita.*
import br.com.zup.minha__musica_favorita.databinding.FragmentListaMusicaBinding
import br.com.zup.minha__musica_favorita.detalhe.album.adapter.ListaMusicaAdapter
import br.com.zup.minha__musica_favorita.model.Musica

class ListaMusicaFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentListaMusicaBinding

    private val listaMusicaAdapter: ListaMusicaAdapter by lazy {
        ListaMusicaAdapter(arrayListOf(), this :: irParaLetraMusica)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaMusicaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adicionarListaMusica()
    }

    private fun exibirRecycleView() {
        binding.rvListaMusica.adapter = listaMusicaAdapter
        binding.rvListaMusica.layoutManager = LinearLayoutManager(this.context)
    }

    private fun adicionarListaMusica() {
        val listaMusica = mutableListOf<Musica>()

        listaMusica.add(Musica(MUSICAS_01, LETRA_MUSICA_01, R.drawable.bita_sentimentos))
        listaMusica.add(Musica(MUSICA_02, LETRA_MUSICA_02, R.drawable.fazendinha))
        listaMusica.add(Musica(MUSICA_03, LETRA_MUSICA_03, R.drawable.bita_animais))
        listaMusica.add(Musica(MUSICA_04, LETRA_MUSICA_04, R.drawable.bita_sentimentos))
        listaMusica.add(Musica(MUSICA_05, LETRA_MUSICA_05, R.drawable.bita_nosso_mundo2))
        listaMusica.add(Musica(MUSICA_06, LETRA_MUSICA_06, R.drawable.bita_e_a_natureza))
        listaMusica.add(Musica(MUSICA_07, LETRA_MUSICA_07, R.drawable.radio_bita))


        listaMusicaAdapter.atualizarListaMusica(listaMusica)
        exibirRecycleView()
    }

    private fun irParaLetraMusica(musica:Musica){
        val intent = Intent(this.context, LetraMusicaActivity :: class.java).apply {
           putExtra(CHAVE_MUSICA, musica)
        }

        startActivity(intent)

    }


}