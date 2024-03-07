package com.myself228.RickAndLoh228.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myself228.RickAndLoh228.common.Resource
import com.myself228.RickAndLoh228.data.model.BaseMainResponse
import com.myself228.RickAndLoh228.data.model.location.RickAndMortyLocation
import com.myself228.RickAndLoh228.ui.App

class LocationViewModel : ViewModel() {
    var liveData = MutableLiveData<Resource<BaseMainResponse<RickAndMortyLocation>?>>()
    fun getLocation(){
        liveData = App.locationRepository.getLocation()
    }
}