package com.gkhn.kotlinnewsapp.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.gkhn.kotlinnewsapp.R
import com.gkhn.kotlinnewsapp.databinding.FragmentMainBinding
import com.gkhn.kotlinnewsapp.model.DataStatus
import com.gkhn.kotlinnewsapp.util.extensions.initHorizontal
import com.gkhn.kotlinnewsapp.view.adapter.HeadLineCategoryRcvAdapter
import com.gkhn.kotlinnewsapp.view.adapter.HeadlinesRcvAdapter
import com.gkhn.kotlinnewsapp.view.viewModel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews(view.context)
        initObservers()
        
        viewModel.apply {
            getTopHeadlines()
            getTopScienceHeadlines()
            getTopSportsHeadlines()
        }
    }

    private fun initRecyclerViews(context: Context) {
        binding.apply {
            rcvHeadlines.initHorizontal(context)
            rcvScience.initHorizontal(context)
            rcvSports.initHorizontal(context)
        }
    }

    private fun initObservers() {
        viewModel.topHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvHeadlines.adapter = HeadlinesRcvAdapter(it.data!!.articles)

                DataStatus.Status.LOADING -> println("loading top headlines")
                else -> println(it.message)
            }
        })

        viewModel.topScienceHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvScience.adapter = HeadLineCategoryRcvAdapter(it.data!!.articles)

                DataStatus.Status.LOADING -> println("loading science")
                else -> println(it.message)
            }
        })

        viewModel.topSportsHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvSports.adapter = HeadLineCategoryRcvAdapter(it.data!!.articles)

                DataStatus.Status.LOADING -> println("loading sports")
                else -> println(it.message)
            }
        })
    }

}