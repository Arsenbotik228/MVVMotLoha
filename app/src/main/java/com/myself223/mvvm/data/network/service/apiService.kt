package com.myself223.mvvm.data.network.service

import com.myself223.mvvm.data.model.BaseMainResponse
import retrofit2.Call
import retrofit2.http.GET

interface apiService {
    @GET("character")
    fun getAllCharacter():Call<BaseMainResponse>

}