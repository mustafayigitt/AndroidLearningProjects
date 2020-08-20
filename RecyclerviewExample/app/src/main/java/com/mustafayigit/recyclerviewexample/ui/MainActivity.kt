package com.mustafayigit.recyclerviewexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustafayigit.recyclerviewexample.R
import com.mustafayigit.recyclerviewexample.mockData.MockList
import com.mustafayigit.recyclerviewexample.model.ProfileData
import com.mustafayigit.recyclerviewexample.ui.adapter.ProfileDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ProfileDataAdapter()
        recyclerViewProfileData.layoutManager = LinearLayoutManager(this)
        recyclerViewProfileData.adapter = adapter

        val mutableLiveData: MutableLiveData<List<ProfileData>> = MutableLiveData()
        mutableLiveData.observe(this, Observer {
            adapter.submitList(it)
        })

        var count = 0
        btnGetAllData.setOnClickListener {
            ++count
            val newData = MockList.getMockData().take(count)
            mutableLiveData.postValue(newData)
        }

        btnGetAllData.setOnLongClickListener {
            count = 0
            mutableLiveData.postValue(emptyList())
            return@setOnLongClickListener true
        }


    }
}
