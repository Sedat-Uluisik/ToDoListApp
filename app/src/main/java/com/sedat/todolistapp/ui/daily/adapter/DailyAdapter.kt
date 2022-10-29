package com.sedat.todolistapp.ui.daily.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sedat.todolistapp.databinding.DailyTitleItemLayoutBinding
import com.sedat.todolistapp.model.Title
import javax.inject.Inject

class DailyAdapter @Inject constructor(): ListAdapter<Title, DailyAdapter.DailyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        return DailyViewHolder(
            DailyTitleItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DailyViewHolder(private val binding: DailyTitleItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(title: Title){
            with(binding){
                titleText.text = title.titleText
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Title>() {
        override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
            return oldItem.Id == newItem.Id
        }

        override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
            return oldItem == newItem
        }
    }
}
