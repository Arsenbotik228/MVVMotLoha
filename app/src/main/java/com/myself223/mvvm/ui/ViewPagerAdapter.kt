package com.myself223.mvvm.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myself223.mvvm.ui.fragments.characters.CharactersFragment
import com.myself223.mvvm.ui.fragments.episode.EpisodeFragment
import com.myself223.mvvm.ui.location.LocationFragment

class ViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragment,lifecycle){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 ->  {
                CharactersFragment()
            }
            1 ->  {
                LocationFragment()
            }
            2 ->  {
                EpisodeFragment()
            }
            else ->{
                Fragment()
            }
        }
    }


}