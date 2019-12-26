package com.jquiroga.accordiondemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.accordiondemo.R
import com.jquiroga.accordiondemo.model.HeadlinesModel
import kotlinx.android.synthetic.main.item_headlines.view.*

class HeadlinesAdapter(): RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>(){

    private val itemList = mutableListOf<HeadlinesModel>()

    fun addItems(pItemList: List<HeadlinesModel>){
        itemList.addAll(pItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_headlines, parent, false)
        return HeadlinesViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    inner class HeadlinesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(headlinesModel: HeadlinesModel){
            itemView.tvTitle.text = headlinesModel.title
            itemView.tvDescription.text = headlinesModel.description
        }
    }
}