package com.mustafayigit.meetat.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.meetat.model.Meeting

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
class MeetingAdapter(
    private val meetingList: ArrayList<Meeting>
) : RecyclerView.Adapter<MeetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MeetViewHolder.create(parent)

    override fun getItemCount() = meetingList.size

    override fun onBindViewHolder(holder: MeetViewHolder, position: Int) =
        holder.bind(meetingList[position])

    fun updateData(newData: List<Meeting>) {
        meetingList.clear()
        meetingList.addAll(newData)
        notifyDataSetChanged()
    }

}