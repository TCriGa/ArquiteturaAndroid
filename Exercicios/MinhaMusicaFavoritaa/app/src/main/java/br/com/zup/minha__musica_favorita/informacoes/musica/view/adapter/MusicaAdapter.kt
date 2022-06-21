package br.com.zup.minha__musica_favorita.informacoes.musica.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minha__musica_favorita.databinding.ListaMusicaItemBinding
import br.com.zup.minha__musica_favorita.informacoes.musica.model.Music

class MusicaAdapter(
    private var listAlbum: MutableList<Music>,
    private val clickMusic : (music: Music) -> Unit
) : RecyclerView.Adapter<MusicaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListaMusicaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val musica = listAlbum[position]
        holder.adicionarInformacoesView(musica)
        holder.binding.cvListaMusica.setOnClickListener {
            clickMusic(musica)
        }

    }

    override fun getItemCount(): Int = listAlbum.size

    fun atualizarListaMusica(novaListaAlbum : MutableList<Music>){
        if (listAlbum.size == 0){
            listAlbum = novaListaAlbum
        }else{
            listAlbum.addAll(novaListaAlbum)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListaMusicaItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun adicionarInformacoesView(album: Music){
            binding.imagemAlbum.setImageResource(album.image)
            binding.textListaMusicas.text = album.listMusic

        }
    }
}
