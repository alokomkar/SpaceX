package com.alokomkar.spacex.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alokomkar.spacex.R
import com.alokomkar.spacex.ui.main.data.LaunchData
import kotlinx.android.synthetic.main.item_launch_schedule.view.*

class ScheduleListAdapter : ListAdapter<LaunchData, ScheduleListAdapter.ListViewHolder>(LaunchDataDiffComparator()) {

    var itemClickListener : ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder
            = ListViewHolder(LayoutInflater
        .from(parent.context)
        .inflate(R.layout.item_launch_schedule, parent, false),
        onItemClickListener = itemClickListener)

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    fun swapData(data: List<LaunchData>) {
        submitList(data.toMutableList())
    }

    interface ItemClickListener {
        fun onItemClicked( item : LaunchData )
    }

    private class LaunchDataDiffComparator : DiffUtil.ItemCallback<LaunchData>() {

        override fun areItemsTheSame(oldItem: LaunchData, newItem: LaunchData): Boolean
                = oldItem.missionName == newItem.missionName

        override fun areContentsTheSame(oldItem: LaunchData, newItem: LaunchData): Boolean
                = oldItem == newItem

    }

    inner class ListViewHolder(
        itemView : View,
        private val onItemClickListener: ItemClickListener? ) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        override fun onClick(view: View?) {
            onItemClickListener?.onItemClicked(getItem(adapterPosition))
        }

        fun bindItem(item: LaunchData) = with(itemView) {
            tvTitle.text = item.missionName
            tvLaunchDate.text = item.launchDateLocal
            tvMissionId.text = if( item.missionId.isNotEmpty() )
                item.missionId[0]
            else
                "Classified"
        }

        init {
            itemView.setOnClickListener(this)
        }

    }

}