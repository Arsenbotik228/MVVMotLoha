package com.myself228.RickAndLoh228.ui.fragments.characters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.myself223.mvvm.databinding.ItemCharacterBinding
import com.myself228.RickAndLoh228.R
import com.myself228.RickAndLoh228.data.model.character.RickAndMortyCharacter
import com.myself228.RickAndLoh228.databinding.ItemCharactersBinding
import com.myself228.mvvmloshpeka.data.model.character.RickAndMortyCharacter

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    private var list = listOf<RickAndMortyCharacter>()

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacter(list: List<RickAndMortyCharacter>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        ViewHolder(binding.root) {

        fun onBind(character: RickAndMortyCharacter) {
            binding.itemTvCharacterName.text = character.name
            binding.itemTvGender.text = character.gender
            binding.itemTvStatus.text = character.status
            binding.itemTvType.text = character.species
            binding.itemTvLastLocation.text = character.location.name
            Glide.with(binding.root).load(character.image).circleCrop()
                .into(binding.itemImgCharacter)

            when (character.status) {
                "Alive" -> binding.itemStatusColor.setBackgroundResource(R.drawable.bg_item_dead)
                "Dead" -> binding.itemStatusColor.setBackgroundResource(R.drawable.bg_item_status)
                "unknown" -> binding.itemStatusColor.setBackgroundResource(R.drawable.bg_item_unknown)
            }


            when (character.gender){
                "Male" -> binding.itemGenderStatusColor.setBackgroundResource(R.drawable.bg_item_mele)
                "Female" -> binding.itemGenderStatusColor.setBackgroundResource(R.drawable.bg_item_female)
                "unknown" -> binding.itemGenderStatusColor.setBackgroundResource(R.drawable.bg_item_unknown)
            }
        }
    }
}