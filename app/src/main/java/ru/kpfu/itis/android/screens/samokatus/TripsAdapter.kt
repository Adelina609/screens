package ru.kpfu.itis.android.screens.samokatus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_samokatus.view.*
import ru.kpfu.itis.android.screens.R

class ToursAdapter :
    ListAdapter<String, ToursAdapter.TourViewHolder>(
        ToursDiffUtilCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TourViewHolder {
        return TourViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_samokatus, parent, false))
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            itemView.tv_title_list_item_samokatus.text = item
            itemView.tv_description_list_item_samokatus.text = item
        }
    }
}

class ToursDiffUtilCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
