package com.myself223.mvvm.ui.location

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself228.mvvmloshpeka.data.model.location.RickAndMortyLocation
import com.myself228.mvvmloshpeka.databinding.ItemLocationBinding





class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>(){
    private var list = listOf<RickAndMortyLocation>()
    @SuppressLint("NotifyDataSetChanged")
    fun setCharacter(list: List<RickAndMortyLocation>) {
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
            binding.tvLocationName1.text = location.name
            binding.tvTypeLocation.text = location.type
            binding.tvDimensionLocation.text = location.dimension
        }
    }
}

