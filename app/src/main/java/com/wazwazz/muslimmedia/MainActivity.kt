package com.wazwazz.muslimmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        ApiClient.retrofit.getCommonMuslimNews().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
                Log.i("MainActivity", "onResponse : ${response.body()}")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Call failed" + t.localizedMessage,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        })
    }
}