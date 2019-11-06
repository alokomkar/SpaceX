package com.alokomkar.spacex.ui.main.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alokomkar.core.extensions.toLiveData
import com.alokomkar.core.networking.Response
import com.alokomkar.spacex.commons.ComponentHolder
import com.alokomkar.spacex.ui.main.data.LaunchData
import com.alokomkar.spacex.ui.main.list.model.ListDataContract
import io.reactivex.disposables.CompositeDisposable

class ListViewModel(private val repo: ListDataContract.Repository,
                    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val scheduleListResponse: LiveData<Response<List<LaunchData>>> by lazy {
        //Convert publish subject to livedata
        repo.launchScheduleListResponse.toLiveData(compositeDisposable)
    }

    var tbd : Boolean? = null

    fun getSchedule( tbd : Boolean? = null ) {
        repo.fetchLaunchSchedule(tbd)
    }

    fun filterSchedule() : Boolean {
        tbd = !(tbd ?: false)
        if( tbd == true ) {
            repo.fetchLaunchSchedule(true)
        }
        else
            repo.fetchLaunchSchedule(null)

        return tbd ?: false
    }

    override fun onCleared() {
        super.onCleared()
        //clear the disposables when the viewmodel is cleared
        compositeDisposable.clear()
        ComponentHolder.destroyListComponent()
    }

}