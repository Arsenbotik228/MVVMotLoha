package com.myself223.mvvm

import android.app.Application
import com.myself228.RickAndLoh228.data.network.repository.CharecterRepository
import com.myself228.RickAndLoh228.data.network.repository.EpisodeRepository
import com.myself228.RickAndLoh228.data.network.repository.LocationRepository
import com.myself228.mvvmloshpeka.data.network.service.ApiService
import com.myself228.mvvmloshpeka.data.network.service.RetrofitClient

class App:Application() {
    companion object {
        lateinit var episodeRepository: EpisodeRepository
        lateinit var charecterRepository: CharecterRepository
        lateinit var locationRepository: LocationRepository
    }

    override fun onCreate() {
        super.onCreate()
        val apiService = RetrofitClient.retrofitInstance.create(ApiService::class.java)
        locationRepository = LocationRepository(apiService)
        episodeRepository = EpisodeRepository(apiService)
        charecterRepository = CharecterRepository(apiService)
    }
}