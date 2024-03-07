package com.myself228.mvvmloshpeka.data.model.location

import com.myself228.mvvmloshpeka.data.model.CharacterInfo

data class BaseResponceLocation(
    val info: CharacterInfo,
    val result: List<RickAndMortyLocation>
)
