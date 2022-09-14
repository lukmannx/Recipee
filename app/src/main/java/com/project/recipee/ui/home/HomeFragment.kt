package com.project.recipee.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.recipee.R
import com.project.recipee.data.adapter.ListFoodAdapter
import com.project.recipee.databinding.FragmentHomeBinding
import com.project.recipee.ui.MainViewModel

class HomeFragment : Fragment() {
    // inisialisasi binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    //inisialisasi viewModel
    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        _viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRandomList()
        viewModel.getResultListUser().observe(viewLifecycleOwner) {
            binding.rvRecipeList.apply {
                adapter = ListFoodAdapter()
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}
