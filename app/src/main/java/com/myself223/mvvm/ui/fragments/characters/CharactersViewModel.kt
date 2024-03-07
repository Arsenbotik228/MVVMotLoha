package com.myself228.RickAndLoh228.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myself228.RickAndLoh228.common.Resource
import com.myself228.RickAndLoh228.data.model.BaseMainResponse
import com.myself228.RickAndLoh228.data.model.character.RickAndMortyCharacter
import com.myself228.RickAndLoh228.ui.App

class CharactersViewModel: ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyCharacter>?>>()
    fun getCharacter(){
        liveData = App.charecterRepository.getCharacter()
    }
}