package com.alokomkar.spacex.ui.main.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alokomkar.core.extensions.handleFailures
import com.alokomkar.core.networking.Response
import com.alokomkar.spacex.R
import com.alokomkar.spacex.commons.ComponentHolder
import com.alokomkar.spacex.ui.main.data.LaunchData
import com.alokomkar.spacex.ui.main.list.viewmodel.ListViewModel
import com.alokomkar.spacex.ui.main.list.viewmodel.ListViewModelFactory
import kotlinx.android.synthetic.main.fragment_schedule_list.*
import javax.inject.Inject

class ListFragment : Fragment(), ScheduleListAdapter.ItemClickListener {

    private val component by lazy { ComponentHolder.listComponent() }
    @Inject
    lateinit var viewModelFactory: ListViewModelFactory
    @Inject
    lateinit var adapter: ScheduleListAdapter

    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_schedule_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)
        adapter.itemClickListener = this
        rvSchedule.adapter = adapter
        viewModel.getSchedule()
        scheduleRefreshLayout.isRefreshing = true
        scheduleRefreshLayout.setOnRefreshListener { viewModel.getSchedule() }
        initialiseDataListener()
    }

    private fun initialiseDataListener() {
        viewModel.scheduleListResponse.observe(this, Observer { response ->
            when( response ) {
                is Response.Progress -> scheduleRefreshLayout.isRefreshing = response.loading
                is Response.Success -> {
                    Log.d("ListScreen", "Success : ${response.data.size}" )
                    adapter.swapData(response.data)
                }
                is Response.Failure -> handleFailures(response.e) { viewModel.getSchedule() }
            }
        })
    }

    override fun onItemClicked(item: LaunchData) {

    }
}