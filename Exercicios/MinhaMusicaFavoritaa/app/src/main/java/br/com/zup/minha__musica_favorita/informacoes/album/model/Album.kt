package br.com.zup.minha__musica_favorita.informacoes.album.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    val imagem: Int,
    val nomeAlbum : String,
    val descricao : String,
    val anoProducao : String,
) : Parcelable