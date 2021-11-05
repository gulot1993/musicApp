package com.example.mymusic.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymusic.R
import com.example.mymusic.core.BaseFragment
import com.example.mymusic.core.ViewModelFactory

class SplashFragment: BaseFragment() {
    private val viewModel: SplashViewModel by viewModels(
        ownerProducer = { requireActivity() },
        factoryProducer = { ViewModelFactory(coreComponent) }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.musics()

        viewModel.status.observe(viewLifecycleOwner, { status ->
            when(status) {
                is SplashStatus.NavigateToDashboard -> {
                    findNavController().navigate(R.id.action_splashFragment_to_dashboardFragment)
                }
            }
        })
    }
}