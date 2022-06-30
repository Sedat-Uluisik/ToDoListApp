package com.sedat.todolistapp.ui.mainactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sedat.todolistapp.ui.todofragment.ToDoFragment

class ViewPagerAdapter(fragmentManager: FragmentActivity): FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int{
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 ->{
                val fragment = ToDoFragment()
                fragment.arguments = Bundle().apply {
                    putInt("type", 0)
                }

                return fragment
            }
            1 ->{
                val fragment = ToDoFragment()
                fragment.arguments = Bundle().apply {
                    putInt("type", 1)
                }

                return fragment
            }
            2 ->{
                val fragment = ToDoFragment()
                fragment.arguments = Bundle().apply {
                    putInt("type", 2)
                }

                return fragment
            }
            3 ->{
                val fragment = ToDoFragment()
                fragment.arguments = Bundle().apply {
                    putInt("type", 3)
                }

                return fragment
            }
            else ->{
                val fragment = ToDoFragment()
                fragment.arguments = Bundle().apply {
                    putInt("type", 0)
                }

                return fragment
            }
        }
    }
}