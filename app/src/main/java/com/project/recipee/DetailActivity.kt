package com.project.recipee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val foodList = intent.extras?.getParcelable<RandomResponseItem>(EXTRA_DATA) as RandomResponseItem

        binding.apply {
            tvDetailTitle.text = foodList.title
            tvServingss.text = foodList.servings.toString()
            tvMinutes.text = foodList.cookingMinutes.toString()
            tvSummary.text = foodList.summary
            tvInstruction.text = foodList.instructions
        }

        Glide.with(this).load(foodList.image).into(binding.imgDetail)

    }

    companion object {
        const val EXTRA_DATA = "Food"
        const val EXTRA_DATA_1 = "Food1"
    }
}