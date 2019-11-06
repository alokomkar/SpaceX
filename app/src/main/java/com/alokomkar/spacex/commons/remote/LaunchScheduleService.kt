package com.alokomkar.spacex.commons.remote

import com.alokomkar.spacex.ui.main.data.LaunchData
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LaunchScheduleService {
    @GET("launches")
    fun getAllLaunches(@Query("tbd") tbd : Boolean? = null): Single<List<LaunchData>>
}