package com.myself223.mvvm.data.network.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ObjectClass {
    private var retrofit:Retrofit? = null
    private val BACE_URL = "https://rickandmortyapi.com/api/"
    val retrofitInstence:Retrofit
        get(){
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BACE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit!!
        }

}