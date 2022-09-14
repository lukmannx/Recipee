package com.project.recipee.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.recipee.data.response.RandomResponseItem
import com.project.recipee.databinding.FragmentHomeBinding
import com.project.recipee.ui.MainViewModel
import kotlin.math.log

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getRandomList()

        viewModel.getResultListUser().observe(viewLifecycleOwner) {
            Log.i("DATA", "onViewCreated: $it")
            it?.randomResponse?.let{ data ->
                showData(data)
            }
        }
    }

    private fun showData(data: List<RandomResponseItem?>) {
        binding.rvRecipeList.apply {
            adapter = HomeAdapter(data)
            layoutManager = GridLayoutManager(context, 2)
        }
    }
}
