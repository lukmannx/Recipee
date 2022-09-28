package com.project.recipee.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recipee.DetailHome
import com.project.recipee.data.response.ResultsItem
import com.project.recipee.databinding.ItemFoodBinding
import com.project.recipee.databinding.ItemSearchBinding
import com.project.recipee.ui.search.SearchAdapter.SearchViewHolder

class SearchAdapter(private var listRecipe: List<ResultsItem?>):
RecyclerView.Adapter<SearchViewHolder>(){

    inner class SearchViewHolder(
        val binding: ItemSearchBinding,
        private val listener : (Int) -> Unit
        ): RecyclerView.ViewHolder(binding.root) {
            init {
                binding.root.setOnClickListener {
                    listener(adapterPosition)
                }
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    ) {
        parent.context.startActivity(
            Intent(
                parent.context,
                DetailHome::class.java
            ).putExtra(DetailHome.EXTRA_DATA_1, listRecipe[it])
                .putExtra(DetailHome.TYPE_DATA, 2)
        )
    }

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
                    Intent(tvTitleSearch.context, DetailHome::class.java)
                        .putExtra(DetailHome.EXTRA_DATA_1, searchRecipe?.id)
                        .putExtra(DetailHome.TYPE_DATA, 2)
                )
            }
        }
    }

    override fun getItemCount(): Int = listRecipe.size
}