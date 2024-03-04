package com.myself228.mvvmloshpeka.data.model

import com.myself228.mvvmloshpeka.data.model.character.RickAndMortyCharacter

data class BaseMainResponse(
    val info: CharacterInfo,
    val results: List<RickAndMortyCharacter>
)