package com.myself228.RickAndLoh228.ui.fragments.characters

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.myself228.RickAndLoh228.common.Resource
import com.myself228.RickAndLoh228.core.BaseFragment
import com.myself228.RickAndLoh228.databinding.FragmentCharactersBinding

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)
    private val adapter: CharacterAdapter by lazy { CharacterAdapter() }
    private val viewModel:CharactersViewModel by lazy { ViewModelProvider(requireActivity())[CharactersViewModel::class.java] }

    override fun initialize() { binding.rvCharacters.adapter = adapter
    viewModel.getCharacter()}

    override fun launchObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Loading -> binding.progressBar.isVisible = true
                is Resource.Success -> {
                    binding.progressBar.isGone = true
                    it.data?.results?.let { it1 -> adapter.setCharacter(it1) }
                }
                is Resource.Error-> {
                    binding.progressBar.isGone = true
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}