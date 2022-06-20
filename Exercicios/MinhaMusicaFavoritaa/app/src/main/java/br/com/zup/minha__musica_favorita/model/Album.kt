package br.com.zup.minha__musica_favorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Album(
    private var imagem: Int,
    private var nomeAlbum : String,
    private var descricao : String,
    private var anoProducao : String,


) : Parcelable {
    fun getImagem() = this.imagem
    fun getNomeAlbum() = this.nomeAlbum
    fun getDescricao() = this.descricao
    fun getAnoProducao() = this.anoProducao

}