package com.project.recipee

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.recipee.data.network.ApiClient
import com.project.recipee.data.response.RandomResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {
    val listInfo = MutableLiveData<RandomResponseItem>()

    fun infoRecipe(id: Int){
        ApiClient.getApiService().getInformation(id).enqueue(object : Callback<RandomResponseItem> {
            override fun onResponse(
                call: Call<RandomResponseItem>,
                response: Response<RandomResponseItem>
            ) {
                listInfo.value = response.body()
            }

            override fun onFailure(call: Call<RandomResponseItem>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }

        })
    }
    fun getInfoRecipe(): LiveData<RandomResponseItem> = listInfo
}