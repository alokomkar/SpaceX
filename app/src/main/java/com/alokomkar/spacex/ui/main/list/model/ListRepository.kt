package com.alokomkar.spacex.ui.main.list.model

import com.alokomkar.core.extensions.*
import com.alokomkar.core.networking.Response
import com.alokomkar.core.networking.Scheduler
import com.alokomkar.spacex.ui.main.data.LaunchData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

class ListRepository(
    private val remote: ListDataContract.Remote,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : ListDataContract.Repository {

    override val launchScheduleListResponse: PublishSubject<Response<List<LaunchData>>>
        get() =  PublishSubject.create<Response<List<LaunchData>>>()

    override fun fetchLaunchSchedule( tbd : Boolean? ) {
        launchScheduleListResponse.loading(true)
        remote.getLaunchSchedule(tbd)
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                { schedulesList -> if( schedulesList != null ) launchScheduleListResponse.success(schedulesList) },
                { error -> handleError(error) })
            .addTo(compositeDisposable)
    }

    override fun handleError(error: Throwable) {
        launchScheduleListResponse.failed(error)
    }
}