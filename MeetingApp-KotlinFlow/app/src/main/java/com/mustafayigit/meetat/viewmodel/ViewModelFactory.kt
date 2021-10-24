package com.mustafayigit.meetat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mustafayigit.meetat.data.repository.MeetingRepository


/**
 * Created By MUSTAFA
 * on 22/05/2020
 */
class ViewModelFactory(
    private val repository: MeetingRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MeetingViewModel(repository) as T
    }
}