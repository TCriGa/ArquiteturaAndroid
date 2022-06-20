package br.com.zup.minha__musica_favorita.detalhe.album

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minha__musica_favorita.*
import br.com.zup.minha__musica_favorita.databinding.FragmentFotosBinding
import br.com.zup.minha__musica_favorita.detalhe.album.adapter.AlbumMusicaAdapter
import br.com.zup.minha__musica_favorita.model.Album

class FotosFragment : Fragment() {

    private lateinit var binding: FragmentFotosBinding

    private val albumAdapter: AlbumMusicaAdapter by lazy {
        AlbumMusicaAdapter(arrayListOf(), this::irParaDetalheClickFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFotosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exibirRecyclerView()


    }

    private fun exibirRecyclerView() {
        adicionarItemListaAlbum()
        binding.rvListaAlbum .adapter = albumAdapter
        binding.rvListaAlbum .layoutManager = GridLayoutManager(context, 2)


    }


    private fun adicionarItemListaAlbum() {
        val listaAlbum = mutableListOf<Album>()

        listaAlbum.add(
            Album(
                R.drawable.bita_sentimentos,
                BITA_E_OS_SENTIMETOS,
                DESCRICAO_SENTIMENTO,
                ANO_SENTIMENTOS,
            )
        )

        listaAlbum.add(
            Album(
                R.drawable.bita_nosso_mundo2,
                BITA_E_NOSSO_MUNDO2,
                DESCRICAO_MUNDO2,
                ANO_BITA_MUNDO2
            )
        )
        listaAlbum.add(
            Album(
                R.drawable.bita_e_o_circo,
                BITA_E_O_CIRCO, DESCRICAO_CIRCO, ANO_BITA_E_O_CIRCO
            )
        )
        listaAlbum.add(
            Album(
                R.drawable.bita_e_o_nosso_mundo,
                BITA_E_O_NOSSO_MUNDO,
                DESCRICAO_NOSSO_MUNDO,
                ANO_NOSSO_MUNDO
            )
        )
        listaAlbum.add(
            Album(
                R.drawable.bita_animais,
                BITA_E_OS_ANIMAIS,
                DESCRICAO_ANIMAIS,
                ANO_E_OS_ANIMAIS
            )
        )
        listaAlbum.add(
            Album(
                R.drawable.bita_e_a_natureza,
                BITA_E_A_NATUREZA,
                DESCRICAO_NATUREZA,
                ANO_NATUREZA
            )
        )
        listaAlbum.add(
            Album(
                R.drawable.bita_e_o_corpo_humano,
                BITA_E_O_CORPO_HUMANO,
                DESCRICAO_HUMANO,
                ANO_CORPO_HUMANO
            )
        )
        listaAlbum.add(
            Album(
                R.drawable.bita_nosso_dia,
                BITA_E_O_NOSSO_DIA,
                DESCRICAO_NOSSO_DIA,
                ANO_NOSSO_DIA
            )
        )
        albumAdapter.atualizarListaAlbum(listaAlbum)

    }

    private fun irParaDetalheClickFragment(album: Album) {

        val intent = Intent(this.context, DetalheAlbumActivity::class.java).apply {
            putExtra(CHAVE_ALBUM, album)
        }

        startActivity(intent)
    }
}





