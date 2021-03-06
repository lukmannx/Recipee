package com.project.recipee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.recipee.databinding.ActivityDetailBinding
import com.project.recipee.databinding.ActivityMainBinding
import com.project.recipee.ui.MainViewModel

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    //inisialisasi viewModel
    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}