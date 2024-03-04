package com.myself223.mvvm.ui.fragments.characters

import android.util.Log
import android.widget.Toast
import com.myself228.mvvmloshpeka.core.BaseFragment
import com.myself228.mvvmloshpeka.data.model.BaseMainResponse
import com.myself228.mvvmloshpeka.data.network.service.ApiService
import com.myself228.mvvmloshpeka.data.network.service.RetrofitClient
import com.myself228.mvvmloshpeka.databinding.FragmentCharactersBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)
    private val adapter: CharacterAdapter by lazy { CharacterAdapter() }

    override fun initialize() {
        binding.rvCharacters.adapter = adapter
    }

    override fun launchObserver() {
        val retrofit = RetrofitClient.retrofitInstance.create(ApiService::class.java)
        retrofit.getAllCharacter().enqueue(object : Callback<BaseMainResponse> {

            override fun onResponse(
                call: Call<BaseMainResponse>,
                response: Response<BaseMainResponse>
            ) {
                if (response.isSuccessful) {
                    val characters = response.body()?.results
                    adapter.setCharacter(characters!!)
                }
            }

            override fun onFailure(call: Call<BaseMainResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("ololo", "${t.message}")
            }
        })
    }

    companion object {
        fun newInstance() = CharactersFragment
    }
}