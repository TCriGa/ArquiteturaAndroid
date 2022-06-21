package br.com.zup.minha__musica_favorita.information.album.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    val image: Int,
    val albumNome: String,
    val describe: String,
    val yearProduct: String,
) : Parcelable