package com.alokomkar.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alokomkar.spacex.ui.main.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .commitNow()
        }
    }

}
