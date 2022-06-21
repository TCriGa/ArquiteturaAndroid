package br.com.zup.minha__musica_favorita.information.music.repository

import br.com.zup.minha__musica_favorita.*
import br.com.zup.minha__musica_favorita.information.music.model.Music

class MusicRepository {

    fun getListMusic(): MutableList<Music> {
        val listMusic = mutableListOf<Music>()

        listMusic.add(Music(MUSICAS_01, LETRA_MUSICA_01, R.drawable.bita_sentimentos))
        listMusic.add(Music(MUSICA_02, LETRA_MUSICA_02, R.drawable.fazendinha))
        listMusic.add(Music(MUSICA_03, LETRA_MUSICA_03, R.drawable.bita_animais))
        listMusic.add(Music(MUSICA_04, LETRA_MUSICA_04, R.drawable.bita_sentimentos))
        listMusic.add(Music(MUSICA_05, LETRA_MUSICA_05, R.drawable.bita_nosso_mundo2))
        listMusic.add(Music(MUSICA_06, LETRA_MUSICA_06, R.drawable.bita_e_a_natureza))
        listMusic.add(Music(MUSICA_07, LETRA_MUSICA_07, R.drawable.radio_bita))

        return listMusic
    }

}