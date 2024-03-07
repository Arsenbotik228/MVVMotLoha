package com.myself228.RickAndLoh228.ui.fragments.location

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.myself223.mvvm.common.Resource
import com.myself223.mvvm.core.BaseFragment
import com.myself223.mvvm.databinding.FragmentLocationBinding


class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    override fun getViewBinding() = FragmentLocationBinding.inflate(layoutInflater)
    private val adapter: LocationAdapter by lazy { LocationAdapter() }
    private val viewModel: LocationViewModel by lazy { ViewModelProvider(requireActivity())[LocationViewModel::class.java] }


    override fun initialize() {
        binding.rvLocation.adapter = adapter
        viewModel.getLocation()
    }
    override fun launchObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Loading<*> -> binding.progressBarLocation.isVisible = true
                is Resource.Success<*> -> {
                    binding.progressBarLocation.isGone = true
                    it.data?.results?.let { it2 -> adapter.setLocation(it2) }
                }
                is Resource.Error-> {
                    binding.progressBarLocation.isGone = true
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
