package com.alokomkar.spacex.ui.main.list.di

import com.alokomkar.core.di.CoreComponent
import com.alokomkar.core.networking.Scheduler
import com.alokomkar.spacex.commons.remote.LaunchScheduleService
import com.alokomkar.spacex.ui.main.list.ListFragment
import com.alokomkar.spacex.ui.main.list.ScheduleListAdapter
import com.alokomkar.spacex.ui.main.list.model.ListDataContract
import com.alokomkar.spacex.ui.main.list.model.ListRemoteData
import com.alokomkar.spacex.ui.main.list.model.ListRepository
import com.alokomkar.spacex.ui.main.list.viewmodel.ListViewModelFactory
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@ListScope
@Component(dependencies = [CoreComponent::class], modules = [ListModule::class])
interface ListComponent {
    fun launchScheduleService(): LaunchScheduleService
    fun scheduler(): Scheduler
    fun inject(fragment: ListFragment)
}

@Module
class ListModule {

    @Provides
    @ListScope
    fun adapter(): ScheduleListAdapter = ScheduleListAdapter()

    /*ViewModel*/
    @Provides
    @ListScope
    fun listViewModelFactory(repository: ListDataContract.Repository, compositeDisposable: CompositeDisposable): ListViewModelFactory = ListViewModelFactory(repository,compositeDisposable)

    /*Repository*/
    @Provides
    @ListScope
    fun listRepo(remote: ListDataContract.Remote, scheduler: Scheduler, compositeDisposable: CompositeDisposable): ListDataContract.Repository = ListRepository(remote, scheduler, compositeDisposable)

    @Provides
    @ListScope
    fun remoteData(scheduleService: LaunchScheduleService): ListDataContract.Remote = ListRemoteData(scheduleService)

    @Provides
    @ListScope
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @ListScope
    fun postService(retrofit: Retrofit): LaunchScheduleService = retrofit.create(LaunchScheduleService::class.java)

}