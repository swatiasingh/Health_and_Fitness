package com.example.health_fitness

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_item_look.view.*

class HistoryAdapter(val context: Context,val items:ArrayList<String>):RecyclerView.Adapter<HistoryAdapter.ViewHolder>()
{
    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val tv_ll=view.historylinearlayout
        val tv_number=view.history_completed
        val tv_item=view.history_date
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.history_item_look,parent,false))
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
      val model:String=items[position]
        holder.tv_number.text=(position+1).toString()
        holder.tv_item.text=model
    }

}