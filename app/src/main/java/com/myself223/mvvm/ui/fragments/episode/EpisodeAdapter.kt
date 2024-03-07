package com.myself228.RickAndLoh228.ui.fragments.episode

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.mvvm.data.model.RickAndMortyEpisode
import com.myself223.mvvm.databinding.ItemEpisodeBinding

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>(){
    private var list = listOf<RickAndMortyEpisode>()

    @SuppressLint("NotifyDataSetChanged")
    fun setLocation(list: List<RickAndMortyEpisode>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeViewHolder(
        ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(episode: RickAndMortyEpisode) {
          /*  with(binding){
                itemTvEpisodeName.text = episode.name
                itemEpisodeTvType.text = episode.air_date
                itemLocationTvDimension.text = episode.episode
            }*/
        }
    }

}