package com.myself223.mvvm.ui.fragments.episode

import com.myself223.mvvm.ui.fragments.characters.CharactersFragment
import com.myself228.mvvmloshpeka.core.BaseFragment
import com.myself228.mvvmloshpeka.databinding.FragmentEpisodeBinding

class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>() {
    override fun getViewBinding() = FragmentEpisodeBinding.inflate(layoutInflater)
    companion object {
        fun newInstance() = CharactersFragment
    }

}