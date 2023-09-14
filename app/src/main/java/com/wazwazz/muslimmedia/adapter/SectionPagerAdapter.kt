package com.wazwazz.muslimmedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wazwazz.muslimmedia.fragment.AboutAlquranFragment
import com.wazwazz.muslimmedia.fragment.AlJazeeraFragment
import com.wazwazz.muslimmedia.fragment.CommonFragment
import com.wazwazz.muslimmedia.fragment.WarmingFragment

// SectionPagerAdapter inheritance FragmentStateAdapter to override instance of adapter
// this is class will used for set in ViewPager2
class SectionPagerAdapter (fa: FragmentActivity): FragmentStateAdapter(fa){
    // getItemCount set amount of fragment which will be display in adapter
    override fun getItemCount()= 4

    override fun createFragment(position: Int): Fragment {
        // set arrange of fragment position from left to right
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlquranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarmingFragment()
            else-> CommonFragment()
        }
    }

}