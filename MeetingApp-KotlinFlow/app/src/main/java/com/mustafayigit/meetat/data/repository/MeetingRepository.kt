package com.mustafayigit.meetat.data.repository

import com.mustafayigit.meetat.data.remote.service.MeetingService
import com.mustafayigit.meetat.model.Meeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
class MeetingRepository(private val service: MeetingService) {

    suspend fun fetchMeetings(): Flow<List<Meeting>> {
        return flow {
            emit(service.fetchMeetings())
        }.flowOn(Dispatchers.IO)
    }

}