package com.sedat.todolistapp.ui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.sedat.todolistapp.FragmentFactoryToDo
import com.sedat.todolistapp.R
import com.sedat.todolistapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    @Inject
    lateinit var fragmentFactoryToDo: FragmentFactoryToDo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.fragmentFactory = fragmentFactoryToDo
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab,position ->
            tab.text = when(position){
                0 -> "Daily"
                1 -> "Weekly"
                2 -> "Monthly"
                3 -> "Yearly"
                else -> "Daily"
            }
        }.attach()
    }
}