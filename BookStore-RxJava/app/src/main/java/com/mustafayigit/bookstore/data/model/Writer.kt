package com.mustafayigit.bookstore.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created By MUSTAFA
 * on 20/05/2020
 */
@Parcelize
data class Writer(
    val id: Int,
    val fullname: String,
    val imageUrl: String,
    val bio: String
) : Parcelable