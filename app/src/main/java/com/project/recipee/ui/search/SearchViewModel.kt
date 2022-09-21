package com.project.recipee.ui.search


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.recipee.data.network.ApiClient
import com.project.recipee.data.response.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    val listRecipe = MutableLiveData<SearchResponse>()

    fun searchRecipe(searchViewString: String){
        ApiClient.getApiService().getRecipes(searchViewString).enqueue(object : Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    listRecipe.value = response.body()
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("error", "vOnFailure: $t")
                }
            })
    }
    fun getSearchRecipe(): LiveData<SearchResponse> = listRecipe
}