package com.myself228.RickAndLoh228.ui.fragments.episode

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.myself228.RickAndLoh228.common.Resource
import com.myself228.RickAndLoh228.core.BaseFragment
import com.myself228.RickAndLoh228.databinding.FragmentEpisodBinding


class EpisodFragment : BaseFragment<FragmentEpisodBinding>() {
    override fun getViewBinding() = FragmentEpisodBinding.inflate(layoutInflater)
    private val adapter: EpisodeAdapter by lazy { EpisodeAdapter() }
    private val viewModel: EpisodeViewModel by lazy { ViewModelProvider(requireActivity())[EpisodeViewModel::class.java] }


    override fun initialize() {
        binding.rvEpisode.adapter = adapter
        viewModel.getLocation()
    }
    override fun launchObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Loading -> binding.progressBarEpisode.isVisible = true
                is Resource.Success -> {
                    binding.progressBarEpisode.isGone = true
                    it.data?.results?.let { it2 -> adapter.setLocation(it2) }
                }
                is Resource.Error-> {
                    binding.progressBarEpisode.isGone = true
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}