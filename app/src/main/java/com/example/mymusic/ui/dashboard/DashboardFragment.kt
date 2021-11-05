package com.example.mymusic.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymusic.R
import com.example.mymusic.core.BaseFragment
import com.example.mymusic.core.ViewModelFactory
import com.example.mymusic.ui.dashboard.adapter.DashboardAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment: BaseFragment() {
    private val viewModel: DashboardViewModel by viewModels(
        ownerProducer = { requireActivity() },
        factoryProducer = { ViewModelFactory(coreComponent) }
    )

    private val adapter by lazy { return@lazy DashboardAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        rvMusics.adapter = adapter
        rvMusics.layoutManager = LinearLayoutManager(requireContext())
        rvMusics.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun setupViewModel() {
        viewModel.loadMusics()

        viewModel.musics.observe(viewLifecycleOwner, { musics ->
            adapter.setData(musics)
        })
    }

    private fun setupViews() {
        tvLastVisitedDate.text = viewModel.lastVisited
    }
}