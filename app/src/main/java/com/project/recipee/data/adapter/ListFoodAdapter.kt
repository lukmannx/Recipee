package com.project.recipee.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recipee.R

class ListFoodAdapter(private val listFood: List<String>) :
    RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType : Int) =
        ListViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_food,viewGroup, false)
        )



    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food = listFood[position]
        Glide.with(holder.itemView.context)
            .load(food)
            .into(holder.imgPhoto)
        holder.tvItemName.text = food
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
    }


}