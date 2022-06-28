package br.com.zup.movieflix.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    var title: String,
    var synopses: String,
    var image: Int,
    var director:String,

    ) : Parcelable