package com.ronald.themoviedb.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ronald.themoviedb.ui.main.fragments.FaveFragment
import com.ronald.themoviedb.ui.main.fragments.PopularFragment
import com.ronald.themoviedb.ui.main.fragments.TopratedFragment

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                PopularFragment()
            }
            1 -> {
                TopratedFragment()
            }
            else -> {
                FaveFragment()
            }
        }
    }
}