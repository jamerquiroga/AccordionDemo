package com.jquiroga.accordiondemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.accordiondemo.R
import com.jquiroga.accordiondemo.model.NewspaperModel
import kotlinx.android.synthetic.main.item_news_paper.view.*

class NewspaperAdapter: RecyclerView.Adapter<NewspaperAdapter.NewspaperViewHolder>() {

    private val newspaperList = mutableListOf<NewspaperModel>()

    fun addNews(pNewspaperList: List<NewspaperModel>){
        newspaperList.addAll(pNewspaperList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewspaperViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_paper, parent, false)
        return NewspaperViewHolder(view)
    }

    override fun getItemCount(): Int = newspaperList.size

    override fun onBindViewHolder(holder: NewspaperViewHolder, position: Int) {
        holder.bind(newspaperList[position], position)
    }

    inner class NewspaperViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(newspaperModel: NewspaperModel, position: Int){

            val headlinesAdapter = HeadlinesAdapter()

            headlinesAdapter.addItems(newspaperModel.paperHeadlines!!)

            itemView.rvHeadlines.apply {
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = headlinesAdapter
            }

            itemView.tvPaperName.text = newspaperModel.paperName

            itemView.ivArrow.setOnClickListener {
                newspaperModel.isExpanded = !newspaperModel.isExpanded!!
                notifyItemChanged(position)
            }

            if(newspaperModel.isExpanded!!){
                itemView.rvHeadlines.visibility = View.VISIBLE
                itemView.ivArrow.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp)
            }else{
                itemView.rvHeadlines.visibility = View.GONE
                itemView.ivArrow.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp)
            }
        }

    }

}