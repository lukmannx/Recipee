package com.project.recipee.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.databinding.ItemFoodBinding
import com.project.recipee.utils.OnItemClickCallback

class ListFoodAdapter() : RecyclerView.Adapter<ListFoodAdapter.MyViewHolder>(){

    private var listFood = ArrayList<RandomResponse>()
//    fun setData(food: List<RandomResponse>?){
//        if (food == null) return
//        listFood.clear()
//        listFood.addAll(food)
//    }

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