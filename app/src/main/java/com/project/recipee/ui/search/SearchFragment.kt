package com.project.recipee.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.recipee.databinding.FragmentSearchBinding
import com.project.recipee.ui.MainViewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding as FragmentSearchBinding

    private var _viewModel: SearchViewModel? = null
    private val viewModel get() = _viewModel as SearchViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//         val  listRecipe =  List<RandomResponseItem>()

        _viewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        viewModel.getSearchRecipe()

        binding.svRecipe.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.let { it?.let { it1 -> viewModel.searchRecipe(it1) } }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.getSearchRecipe().observe(viewLifecycleOwner){
            Log.d("SearchFragment", "onViewCreated: ${it.results}")
            binding.rvSearch.apply {
                adapter = it.results?.let { it1 -> SearchAdapter(it1) }
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}