package com.wazwazz.muslimmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.wazwazz.muslimmedia.adapter.SectionPagerAdapter
import com.wazwazz.muslimmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolBar)
        setContentView(binding.root)

        // set adapter ViewPager2 using SectionPagerAdapter class
        binding.vpContainer.adapter = SectionPagerAdapter(this)
        // array for set tittle tab item in layout
        val listFragment = arrayOf("Common", "About Quran", "Al-Jazeera", "Warming")
        // set TabLayout and ViewPager2 so, can bin each other
        TabLayoutMediator(binding.tablayout, binding.vpContainer) {tab, position ->
            tab.text = listFragment[position]
        }.attach()
    }
}