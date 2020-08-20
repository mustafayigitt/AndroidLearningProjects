package com.mustafayigit.recyclerviewexample.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mustafayigit.recyclerviewexample.model.ProfileData

/**
 * Created By MUSTAFA
 * on 26/03/2020
 */

class ProfileDataAdapter :
    ListAdapter<ProfileData, ProfileDataViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileDataViewHolder =
        ProfileDataViewHolder(parent)

    override fun onBindViewHolder(holder: ProfileDataViewHolder, position: Int) =
        holder.bind(getItem(position))

    class DiffCallback : DiffUtil.ItemCallback<ProfileData>() {
        override fun areItemsTheSame(oldItem: ProfileData, newItem: ProfileData): Boolean =
            oldItem.fullName == newItem.fullName

        override fun areContentsTheSame(oldItem: ProfileData, newItem: ProfileData): Boolean =
            oldItem.toString() == newItem.toString()

    }
}