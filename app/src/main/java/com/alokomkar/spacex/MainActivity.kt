package com.alokomkar.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alokomkar.spacex.ui.main.data.LaunchData
import com.alokomkar.spacex.ui.main.details.DetailsFragment
import com.alokomkar.spacex.ui.main.list.ListFragment
import com.alokomkar.spacex.ui.main.list.ScheduleListAdapter

class MainActivity : AppCompatActivity(), ScheduleListAdapter.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .commitNow()
        }
    }

    override fun onItemClicked(item: LaunchData) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(DetailsFragment.SELECTED_ITEM, item)
                }
            })
            addToBackStack("DetailsScreen")
        }.commit()
    }

    override fun onBackPressed() {
        if( supportFragmentManager.backStackEntryCount > 1 ) {
            supportFragmentManager.popBackStack()
        }
        else
            super.onBackPressed()
    }

}
