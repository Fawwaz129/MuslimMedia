package com.wazwazz.muslimmedia

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.wazwazz.muslimmedia.adapter.SectionPagerAdapter
import com.wazwazz.muslimmedia.data.NewsResponse
import com.wazwazz.muslimmedia.data.network.ApiClient
import com.wazwazz.muslimmedia.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolBar)
        setContentView(binding.root)

        // set adapter ViewPager2 using SectionPagerAdapter class
        binding.vpContainer.adapter = SectionPagerAdapter(this)
        // array for set tittle tab item in layout
        val listFragment = arrayOf("Common", "About Quran", "Al-Jazeera", "Warming")
        // set TabLayout and ViewPager2 so, can bin each other
        TabLayoutMediator(binding.tablayout, binding.vpContainer) { tab, position ->
            tab.text = listFragment[position]
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchView = menu?.findItem(R.id.option_search)?.actionView as SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_search -> onSearchRequested()
            else -> super.onOptionsItemSelected(item)
        }
    }
}