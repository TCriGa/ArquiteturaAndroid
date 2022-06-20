package br.com.zup.minha__musica_favorita.detalhe.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minha__musica_favorita.databinding.ListaAlbumItemBinding
import br.com.zup.minha__musica_favorita.model.Album

class AlbumMusicaAdapter(
    private var listaAlbum: MutableList<Album>,
    private var cliclAlbum: (album : Album) -> Unit
) : RecyclerView.Adapter<AlbumMusicaAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ListaAlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val albumMusica = listaAlbum[position]
        holder.adicionarInformacoesView(albumMusica as Album)
        holder.binding.cvItemLista.setOnClickListener {
            cliclAlbum(albumMusica)
        }

    }

    override fun getItemCount(): Int = listaAlbum.size

    fun atualizarListaAlbum(novaLista : MutableList<Album>){
        if (listaAlbum.size == 0){
            listaAlbum = novaLista
        }else{
            listaAlbum.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListaAlbumItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun adicionarInformacoesView(album:Album){
            binding.ivHeroi.setImageResource(album.getImagem())

        }
    }
}
