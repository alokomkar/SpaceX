package com.alokomkar.spacex.ui.main.list.model

import com.alokomkar.core.networking.Response
import com.alokomkar.spacex.ui.main.data.LaunchData
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

interface ListDataContract {

    interface Repository {
        val launchScheduleListResponse : PublishSubject<Response<List<LaunchData>>>
        fun fetchLaunchSchedule(tbd: Boolean?)
        fun handleError( error : Throwable )
    }

    interface Remote {
        fun getLaunchSchedule(tbd : Boolean?): Single<List<LaunchData>>
    }
}