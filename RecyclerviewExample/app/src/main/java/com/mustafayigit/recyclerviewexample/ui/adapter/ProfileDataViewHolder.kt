package com.mustafayigit.recyclerviewexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mustafayigit.recyclerviewexample.R
import com.mustafayigit.recyclerviewexample.model.ProfileData
import kotlinx.android.synthetic.main.adapter_item_profile_data.view.*

/**
 * Created By MUSTAFA
 * on 26/03/2020
 */
class ProfileDataViewHolder(container: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(container.context).inflate(
            R.layout.adapter_item_profile_data,
            container,
            false
        )
    ) {

    fun bind(profileData: ProfileData) {
        itemView.txtFullName.text = profileData.fullName
        itemView.txtDepartment.text = profileData.department
        Glide
            .with(itemView.context)
            .load(profileData.photoUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(itemView.imgProfilePhoto)
    }

}