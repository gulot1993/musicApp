package com.example.mymusic

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mymusic.R
import com.example.mymusic.core.BaseActivity
import com.example.mymusic.core.ViewModelFactory
import com.example.mymusic.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.DateTime
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {
    private val viewModel: DashboardViewModel by viewModels(
        factoryProducer = { ViewModelFactory(coreComponent) }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLastVisitedValue()
        setupNavigation()
    }

    private fun setupNavigation() {
        val controller = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboardFragment)
        )

        toolbar.setupWithNavController(controller, appBarConfiguration)

        controller.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.splashFragment -> {
                    toolbar.visibility = View.GONE
                }
                R.id.dashboardFragment -> {
                    toolbar.visibility = View.VISIBLE
                    tvTitle.text = getString(R.string.app_name)
                }
            }
        }
    }

    private fun setLastVisitedValue() {
        val now = Calendar.getInstance().time
        val sdf = SimpleDateFormat("dd-MMM-yyyy")

        viewModel.lastVisited = sdf.format(now)
    }
}