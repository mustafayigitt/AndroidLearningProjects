package com.mustafayigit.meetat.data.remote.service

import com.mustafayigit.meetat.model.Meeting
import retrofit2.http.GET

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
interface MeetingService {

    @GET("5ec7be262f00006e00427413")
    suspend fun fetchMeetings(): List<Meeting>
}