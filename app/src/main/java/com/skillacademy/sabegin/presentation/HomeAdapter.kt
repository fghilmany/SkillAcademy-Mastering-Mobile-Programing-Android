package com.skillacademy.sabegin.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skillacademy.sabegin.R
import com.skillacademy.sabegin.data.Result
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val result: List<Result>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false))

    }

    override fun getItemCount(): Int {
        return  result.count()

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(result[holder.adapterPosition])
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(result: Result){
            with(itemView){
                tv_title.text = result.title
                tv_overview.text = result.overview
            }
        }

    }

}
