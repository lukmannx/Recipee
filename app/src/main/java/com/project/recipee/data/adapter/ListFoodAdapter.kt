package com.project.recipee.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.databinding.ItemFoodBinding

class ListFoodAdapter(private var listFood: ArrayList<RandomResponse>) : RecyclerView.Adapter<ListFoodAdapter.MyViewHolder>(){

    fun setData(food: List<RandomResponse>?){
        if (food == null) return
        listFood.clear()
        listFood.addAll(food)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class MyViewHolder(val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType : Int) =

        MyViewHolder(
            ItemFoodBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val food = listFood[position]
        holder.binding.apply {
            //title
             //title dari RandomResponse
            itemName.text = food.title

             //photo
            Glide.with(itemPhoto.context)
                .load(food.image)
                .apply {RequestOptions()}
                .override(500,500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(itemPhoto)

            holder.itemView.setOnClickListener{
                onItemClickCallback?.onItemClicked(food)
            }
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }
}