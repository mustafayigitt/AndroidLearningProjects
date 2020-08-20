package com.mustafayigit.navigationcomponentexample.ui.dashboard

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mustafayigit.navigationcomponentexample.R


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val args by navArgs<DashboardFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.text_dashboard).text = args.textArgs
    }
}