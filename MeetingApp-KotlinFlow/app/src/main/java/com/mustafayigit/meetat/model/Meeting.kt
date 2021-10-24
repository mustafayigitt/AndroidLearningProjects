package com.mustafayigit.meetat.model

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
data class Meeting(
    val id: Int,
    val name: String,
    val organization: String,
    val coverUrl: String,
    val date: String,
    val location: String,
    val users: List<User>
)