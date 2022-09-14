package com.project.recipee.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.project.recipee.R
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.databinding.ItemFoodBinding

class ListFoodAdapter(private val listFood: List<RandomResponse>): RecyclerView.Adapter<ListFoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(
            ItemFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodList = listFood[position]
        holder.binding.apply {
            itemName.text = foodList.title

            Glide.with(itemPhoto)
                .load(foodList.image)
                .into(itemPhoto)
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }
}