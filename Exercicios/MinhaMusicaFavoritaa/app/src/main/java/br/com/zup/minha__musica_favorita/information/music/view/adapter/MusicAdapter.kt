package br.com.zup.minha__musica_favorita.information.music.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minha__musica_favorita.databinding.MusicListItemBinding
import br.com.zup.minha__musica_favorita.information.music.model.Music

class MusicAdapter(
    var listAlbum: MutableList<Music>,
    private val clickMusic: (music: Music) -> Unit
) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MusicListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val music = listAlbum[position]
        holder.additionalInformaticsView(music)
        holder.binding.cvListaMusica.setOnClickListener {
            clickMusic(music)
        }

    }

    override fun getItemCount(): Int = listAlbum.size

    class ViewHolder(val binding: MusicListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun additionalInformaticsView(album: Music) {
            binding.imagemAlbum.setImageResource(album.image)
            binding.textListaMusicas.text = album.listMusic
        }
    }
}
