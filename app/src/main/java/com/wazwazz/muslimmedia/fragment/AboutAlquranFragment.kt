package com.wazwazz.muslimmedia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wazwazz.muslimmedia.NewsViewModel
import com.wazwazz.muslimmedia.R
import com.wazwazz.muslimmedia.adapter.NewsAdapter
import com.wazwazz.muslimmedia.databinding.FragmentAboutAlquranBinding

class AboutAlquranFragment : Fragment() {
    private var _binding : FragmentAboutAlquranBinding? = null
    private val binding get() = _binding as FragmentAboutAlquranBinding
    private var _viewModel : NewsViewModel? = null
    private val viewModel get() = _viewModel as NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAboutAlquranBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getAboutAlquranNews()
        viewModel.aboutAlQuran.observe(viewLifecycleOwner){
            val data = it.articles
            binding.rvAboutQuran.apply {
                val mAdapter = NewsAdapter()
                mAdapter.setData(data)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
        binding.loadingView.root.visibility = View.GONE
    }
}