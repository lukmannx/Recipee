package com.project.recipee

import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.databinding.ActivityDetailBinding
import com.project.recipee.databinding.ActivityMainBinding
import com.project.recipee.ui.MainViewModel

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val foodList = intent.extras?.getParcelable<RandomResponseItem>(EXTRA_DATA) as RandomResponseItem

        binding.tvDetailTitle.text = foodList.title
        binding.tvServingss.text = foodList.servings.toString()
        binding.tvMinutes.text = foodList.cookingMinutes.toString()
        binding.tvSummary.text = foodList.summary
        binding.tvInstruction.text = foodList.instructions

        Glide.with(this).load(foodList.image).into(binding.imgDetail)

    }

    companion object {
        const val EXTRA_DATA = "Food"
    }
}