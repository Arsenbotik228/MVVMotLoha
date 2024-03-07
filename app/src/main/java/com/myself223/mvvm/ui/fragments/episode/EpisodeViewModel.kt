package com.myself228.RickAndLoh228.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myself223.mvvm.App
import com.myself223.mvvm.common.Resource
import com.myself223.mvvm.data.model.RickAndMortyEpisode
import com.myself228.mvvmloshpeka.data.model.BaseMainResponse

class EpisodeViewModel:ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyEpisode>?>>()
    fun getLocation(){
        liveData = App.episodeRepository.getEpisode()
    }
}