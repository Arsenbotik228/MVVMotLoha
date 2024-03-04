package com.myself228.mvvmloshpeka.data.network.service

import com.myself228.mvvmloshpeka.data.model.BaseMainResponse
import com.myself228.mvvmloshpeka.data.model.location.BaseResponceLocation
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getAllCharacter(): Call<BaseMainResponse>
    @GET("location")
    fun getAllLocation(): Call<BaseResponceLocation>
}