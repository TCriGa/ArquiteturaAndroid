package br.com.zup.minha__musica_favorita.information.album.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minha__musica_favorita.databinding.AlbumListItemBinding
import br.com.zup.minha__musica_favorita.information.album.model.Album

class AlbumAdapter(
    var AlbumList: MutableList<Album>,
    private var clickAlbum: (album: Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AlbumListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val albumMusic = AlbumList[position]
        holder.additionalInformaticsView(albumMusic as Album)
        holder.binding.cvItemLista.setOnClickListener {
            clickAlbum(albumMusic)
        }

    }

    override fun getItemCount(): Int = AlbumList.size


    class ViewHolder(val binding: AlbumListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun additionalInformaticsView(album: Album) {
            binding.ivHeroi.setImageResource(album.image)

        }
    }
}
