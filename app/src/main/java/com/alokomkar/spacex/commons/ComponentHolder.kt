package com.alokomkar.spacex.commons

import com.alokomkar.core.application.CoreApp
import com.alokomkar.spacex.ui.main.list.di.DaggerListComponent
import com.alokomkar.spacex.ui.main.list.di.ListComponent
import javax.inject.Singleton

@Singleton
object ComponentHolder {
    private var listComponent: ListComponent? = null

    fun listComponent(): ListComponent {
        if (listComponent == null)
            listComponent = DaggerListComponent.builder().coreComponent(CoreApp.coreComponent).build()
        return listComponent as ListComponent
    }

    fun destroyListComponent() {
        listComponent = null
    }
}