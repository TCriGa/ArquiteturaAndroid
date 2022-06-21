package br.com.zup.minha__musica_favorita.information.music.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    var listMusic : String,
    var letterMusic: String,
    var image : Int
) : Parcelable