package com.myself223.mvvm.ui.location

import com.myself228.mvvmloshpeka.core.BaseFragment
import com.myself228.mvvmloshpeka.data.model.location.BaseResponceLocation
import com.myself228.mvvmloshpeka.data.network.service.ApiService
import com.myself228.mvvmloshpeka.data.network.service.RetrofitClient
import com.myself228.mvvmloshpeka.databinding.FragmentLocationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    override fun getViewBinding() = FragmentLocationBinding.inflate(layoutInflater)

    private val adapter: LocationAdapter by lazy { LocationAdapter() }


    override fun initialize() {
        binding.rvLocation.adapter = adapter
    }


    override fun launchObserver() {
        val retrofit = RetrofitClient.retrofitInstance.create(ApiService::class.java)
        retrofit.getAllLocation().enqueue(object : Callback<BaseResponceLocation>{
            override fun onResponse(
                call: Call<BaseResponceLocation>,
                response: Response<BaseResponceLocation>
            ) {

            }

            override fun onFailure(call: Call<BaseResponceLocation>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    companion object{
        fun newInstance() = LocationFragment
    }
}