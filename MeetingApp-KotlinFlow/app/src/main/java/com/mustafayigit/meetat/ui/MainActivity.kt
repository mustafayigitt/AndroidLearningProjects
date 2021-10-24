package com.mustafayigit.meetat.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mustafayigit.meetat.R
import com.mustafayigit.meetat.adapter.MeetingAdapter
import com.mustafayigit.meetat.data.remote.ApiClient
import com.mustafayigit.meetat.data.remote.service.MeetingService
import com.mustafayigit.meetat.data.repository.MeetingRepository
import com.mustafayigit.meetat.databinding.ActivityMainBinding
import com.mustafayigit.meetat.viewmodel.MeetingViewModel
import com.mustafayigit.meetat.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var service: MeetingService
    private lateinit var repository: MeetingRepository
    private lateinit var viewModel: MeetingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        service = ApiClient.getClient<MeetingService>().create(MeetingService::class.java)
        repository = MeetingRepository(service)
        viewModel =
            ViewModelProvider(
                this,
                ViewModelFactory(repository)
            )[MeetingViewModel::class.java].apply { getMeetings() }

        initUI()
    }

    private fun initUI() {
        binding.recyclerMeeting.adapter = MeetingAdapter(arrayListOf())
        viewModel.meetingList.observe(this, Observer {
            (binding.recyclerMeeting.adapter as MeetingAdapter).updateData(it.data.orEmpty())

        })
    }
}
