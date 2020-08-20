package com.mustafayigit.navigationcomponentexample.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.mustafayigit.navigationcomponentexample.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnGoDashboard).setOnClickListener {
            val argValue = view.findViewById<EditText>(R.id.edtArgs).text.toString()
            it.findNavController()
                .navigate(
                    HomeFragmentDirections
                        .actionNavigationHomeToNavigationDashboard(argValue)
                )
        }

        view.findViewById<Button>(R.id.btnGoNotification).setOnClickListener {
            it.findNavController()
                .navigate(
                    R.id.action_navigation_home_to_navigation_notifications
                )
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
    }
}