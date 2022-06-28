package br.com.zup.movieflix.moviedetail.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DirectorModel(
    var directorName: String,
    var directorInfo : String
) : Parcelable