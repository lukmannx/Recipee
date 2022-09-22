package com.project.recipee.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recipee.DetailActivity
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.data.response.ResultsItem
import com.project.recipee.databinding.ItemFoodBinding
import com.project.recipee.databinding.ItemSearchBinding
import com.project.recipee.ui.search.SearchAdapter.SearchViewHolder

class SearchAdapter(private var listRecipe: List<ResultsItem?>):
RecyclerView.Adapter<SearchViewHolder>(){

    inner class SearchViewHolder(val binding: ItemSearchBinding):
            RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val searchRecipe = listRecipe[position]
        holder.binding.apply {
            tvTitleSearch.text = searchRecipe?.title
//            tvHealthscoreItem.text = searchRecipe?.healthScore.toString()


            Glide.with(ivSearch)
                .load(searchRecipe?.image)
                .into(ivSearch)

            root.setOnClickListener{

                tvTitleSearch.context.startActivity(
                    Intent(tvTitleSearch.context, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_DATA_1, searchRecipe)
                )
            }
        }
    }

    override fun getItemCount(): Int = listRecipe.size
}