package br.com.zup.minha__musica_favorita.information.album.repository

import br.com.zup.minha__musica_favorita.*
import br.com.zup.minha__musica_favorita.information.album.model.Album

class AlbumRepository {

    fun getAlbumList(): MutableList<Album> {
        val albumList = mutableListOf<Album>()

        albumList.add(
            Album(
                R.drawable.bita_sentimentos,
                BITA_E_OS_SENTIMETOS,
                DESCRICAO_SENTIMENTO,
                ANO_SENTIMENTOS,
            )
        )

        albumList.add(
            Album(
                R.drawable.bita_nosso_mundo2,
                BITA_E_NOSSO_MUNDO2,
                DESCRICAO_MUNDO2,
                ANO_BITA_MUNDO2
            )
        )
        albumList.add(
            Album(
                R.drawable.bita_e_o_circo,
                BITA_E_O_CIRCO, DESCRICAO_CIRCO, ANO_BITA_E_O_CIRCO
            )
        )
        albumList.add(
            Album(
                R.drawable.bita_e_o_nosso_mundo,
                BITA_E_O_NOSSO_MUNDO,
                DESCRICAO_NOSSO_MUNDO,
                ANO_NOSSO_MUNDO
            )
        )
        albumList.add(
            Album(
                R.drawable.bita_animais,
                BITA_E_OS_ANIMAIS,
                DESCRICAO_ANIMAIS,
                ANO_E_OS_ANIMAIS
            )
        )
        albumList.add(
            Album(
                R.drawable.bita_e_a_natureza,
                BITA_E_A_NATUREZA,
                DESCRICAO_NATUREZA,
                ANO_NATUREZA
            )
        )
        albumList.add(
            Album(
                R.drawable.bita_e_o_corpo_humano,
                BITA_E_O_CORPO_HUMANO,
                DESCRICAO_HUMANO,
                ANO_CORPO_HUMANO
            )
        )
        albumList.add(
            Album(
                R.drawable.bita_nosso_dia,
                BITA_E_O_NOSSO_DIA,
                DESCRICAO_NOSSO_DIA,
                ANO_NOSSO_DIA
            )
        )
        return albumList
    }
}