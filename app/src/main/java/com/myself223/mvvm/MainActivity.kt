package com.myself223.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.myself223.mvvm.databinding.ActivityMainBinding
import com.myself223.mvvm.databinding.FragmentCharactersBinding

class MainActivity : AppCompatActivity() {
    private val fragList = listOf(fragmentManager.fragments.size)
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tbL.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction().replace(com.google.android.material.R.id.textinput_placeholder,fragList)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        } )
    }
}

private fun FragmentTransaction.replace(textinputPlaceholder: Int, fragList: List<Int>) {


}
