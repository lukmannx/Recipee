package com.project.recipee.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.project.recipee.DetailActivity
import com.project.recipee.R
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
            tvHealthscoreItem.text = homeList?.healthScore.toString()

            val photo = homeList?.image
            Glide.with(itemPhoto)
                .load(photo)
                .apply(RequestOptions())
                .placeholder(R.drawable.ic_card_image)
                .override(500, 500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
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