package com.alokomkar.spacex.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alokomkar.spacex.R
import com.alokomkar.spacex.ui.main.data.LaunchData
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(arguments?.getParcelable<LaunchData>(SELECTED_ITEM) ?: LaunchData()) {
            tvRocketName.text = rocket.rocketName
            tvRocketDescription.text = details ?: "Classified"
        }
    }

    companion object {
        const val SELECTED_ITEM = "selectedItem"
    }
}