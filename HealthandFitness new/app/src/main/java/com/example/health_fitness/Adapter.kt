package com.example.health_fitness

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_item_look.view.*

class RecyclerViewAdapter(val items:ArrayList<exerciseModel>,val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
{
    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
               val tvitem = view.item_tv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_look,parent,false))
    }

    override fun getItemCount(): Int {
         return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model:exerciseModel=items[position]
        holder.tvitem.text=model.id.toString()
        if(model.isSelected)
            holder.tvitem.background=ContextCompat.getDrawable(context,R.drawable.exercise_ongoing)
        else if(model.isCompleted)
            holder.tvitem.background=ContextCompat.getDrawable(context,R.drawable.exercise_completed)
    }

}