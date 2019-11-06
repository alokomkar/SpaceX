package com.alokomkar.spacex.ui.main.list.model

import com.alokomkar.spacex.commons.remote.LaunchScheduleService
import com.alokomkar.spacex.ui.main.data.LaunchData
import io.reactivex.Single

class ListRemoteData( private val service: LaunchScheduleService ) : ListDataContract.Remote {
    override fun getLaunchSchedule(tbd : Boolean?): Single<List<LaunchData>> = service.getAllLaunches(tbd)
}