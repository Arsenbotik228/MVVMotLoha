package com.myself228.RickAndLoh228.ui.fragments.location

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.mvvm.databinding.ItemLocationBinding
import com.myself228.mvvmloshpeka.data.model.location.RickAndMortyLocation

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>(){
    private var list = listOf<RickAndMortyLocation>()

    @SuppressLint("NotifyDataSetChanged")
    fun setLocation(list: List<RickAndMortyLocation>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LocationViewHolder(
        ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(location: RickAndMortyLocation) {
            /*binding.itemTvLocationName.text = location.name
            binding.itemLocationTvType.text = location.type
            binding.itemLocationTvDimension.text = location.dimension*/
        }
    }

}
