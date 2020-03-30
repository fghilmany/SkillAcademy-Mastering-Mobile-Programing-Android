package com.skillacademy.sabegin.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.skillacademy.sabegin.R
import com.skillacademy.sabegin.data.Result
import com.skillacademy.sabegin.databinding.ItemHomeBinding

class HomeAdapter(private val result: List<Result>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return  result.count()

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.apply {
            viewmodel = HomeAdapterViewModel(result[holder.adapterPosition])
            executePendingBindings()
        }
    }

    inner class HomeViewHolder(val binding : ItemHomeBinding) : RecyclerView.ViewHolder(binding.root)

}
