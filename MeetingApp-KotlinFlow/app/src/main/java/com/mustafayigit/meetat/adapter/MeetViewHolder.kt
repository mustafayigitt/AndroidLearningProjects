package com.mustafayigit.meetat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.meetat.R
import com.mustafayigit.meetat.databinding.AdapterItemMeetingBinding
import com.mustafayigit.meetat.model.Meeting

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
class MeetViewHolder(
    private val binding: AdapterItemMeetingBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(container: ViewGroup): MeetViewHolder {
            return MeetViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.adapter_item_meeting,
                    container,
                    false
                )
            )
        }
    }

    fun bind(meeting: Meeting) {
        binding.meeting = meeting
    }

}