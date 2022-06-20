package br.com.zup.minha__musica_favorita.detalhe.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minha__musica_favorita.databinding.ListaMusicaItemBinding
import br.com.zup.minha__musica_favorita.model.Album
import br.com.zup.minha__musica_favorita.model.Musica

class ListaMusicaAdapter(
    private var listaAlbum: MutableList<Musica>,
    private val clickMusica : (musica: Musica) -> Unit
) : RecyclerView.Adapter<ListaMusicaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListaMusicaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val musica = listaAlbum[position]
        holder.adicionarInformacoesView(musica)
        holder.binding.cvListaMusica.setOnClickListener {
            clickMusica(musica)
        }

    }

    override fun getItemCount(): Int = listaAlbum.size

    fun atualizarListaMusica(novaListaAlbum : MutableList<Musica>){
        if (listaAlbum.size == 0){
            listaAlbum = novaListaAlbum
        }else{
            listaAlbum.addAll(novaListaAlbum)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListaMusicaItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun adicionarInformacoesView(album: Musica){
            binding.imagemAlbum.setImageResource(album.getImagem())
            binding.textListaMusicas.text = album.getListaMusica()

        }
    }
}
