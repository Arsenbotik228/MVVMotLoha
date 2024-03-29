package com.myself228.mvvmloshpeka.data.model.character

import com.myself228.mvvmloshpeka.data.model.location.RickAndMortyLocation

data class RickAndMortyCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: RickAndMortyOrigin,
    val image: String,
    val location: RickAndMortyLocation
)