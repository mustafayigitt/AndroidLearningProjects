package com.mustafayigit.bookstore.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created By MUSTAFA
 * on 20/05/2020
 */
@Parcelize
data class Book(
    val id: Int,
    val title: String,
    val category: String,
    val cover: String,
    val summary: String,
    val writer: List<Writer>
) : Parcelable