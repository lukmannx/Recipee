package com.project.recipee.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recipee.DetailActivity
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.databinding.ItemFoodBinding

class HomeAdapter(private val homeRecipe: List<RandomResponseItem?>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(
            ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val homeList = homeRecipe[position]
        holder.binding.apply {
            itemName.text = homeList?.title

            Glide.with(itemPhoto)
                .load(homeList?.image)
                .into(itemPhoto)

            root.setOnClickListener{

                itemName.context.startActivity(
                    Intent(itemName.context, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_DATA, homeList)
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return homeRecipe.size
    }
}