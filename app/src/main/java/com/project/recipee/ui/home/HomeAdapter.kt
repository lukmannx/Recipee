package com.project.recipee.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.databinding.ItemFoodBinding

class HomeAdapter(private val homeRecipe: List<RandomResponseItem>?) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(
            ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val homeList = homeRecipe?.get(position)
        holder.binding.apply {
            itemName.text = homeList?.title

            Glide.with(itemPhoto)
                .load(homeList?.image)
                .into(itemPhoto)
        }
    }

    override fun getItemCount(): Int {
        return homeRecipe!!.size
    }
}