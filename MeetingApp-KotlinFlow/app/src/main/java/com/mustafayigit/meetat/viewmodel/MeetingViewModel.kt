package com.mustafayigit.meetat.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafayigit.meetat.data.remote.Resource
import com.mustafayigit.meetat.data.remote.Status
import com.mustafayigit.meetat.data.repository.MeetingRepository
import com.mustafayigit.meetat.model.Meeting
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
class MeetingViewModel(
    private val meetingRepository: MeetingRepository
) : ViewModel() {

    val meetingList = MutableLiveData<Resource<List<Meeting>>>()

    fun getMeetings() {
        viewModelScope.launch {
            meetingRepository.fetchMeetings()
                .onStart { meetingList.postValue(Resource(Status.LOADING, null, null)) }
                .catch { error ->
                    meetingList.postValue(
                        Resource(
                            Status.ERROR,
                            null,
                            error.message
                        )
                    )
                }
                .collect { source -> meetingList.postValue(Resource(Status.SUCCESS, source, null)) }
        }
    }

}