package com.project.recipee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.databinding.ActivityDetailHomeBinding

class DetailHome : AppCompatActivity() {
    private var _binding: ActivityDetailHomeBinding? = null
    private val binding get() = _binding as ActivityDetailHomeBinding

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel as DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.elevation = 0f

        _viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        val idRecipes : Int = when (intent.extras?.getInt(DetailHome.TYPE_DATA, 0)) {
            1 -> intent.getIntExtra(DetailHome.EXTRA_DATA_1, 0)
            2 -> intent.getIntExtra(DetailHome.EXTRA_DATA_1, 0)
            else -> 0
        }
        viewModel.infoRecipe(idRecipes)
        viewModel.getInfoRecipe().observe(this) {
            binding.apply {
                tvDetailTitle.text = it.title
                tvServingss.text = it.servings.toString()
                tvMinutes.text = it.cookingMinutes.toString()
                tvSummary.text = it.summary
                tvInstruction.text = it.instructions
                Glide.with(this@DetailHome).load(it.image).into(binding.imgDetail)
            }
        }
    }

    companion object {
        const val EXTRA_DATA_1 = "Food1"
        const val TYPE_DATA = "key"
    }
}

