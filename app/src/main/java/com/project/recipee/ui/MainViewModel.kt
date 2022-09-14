package com.project.recipee.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.recipee.data.network.ApiClient
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.RandomResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listFood = MutableLiveData<List<RandomResponse>>()

    fun getRandomList(){
        ApiClient.getApiService().getRandom().enqueue(object : Callback<List<RandomResponse>> {
            override fun onResponse(
                call: Call<List<RandomResponse>>,
                response: Response<List<RandomResponse>>
            ) {
//                val arrayBaru = arrayListOf<RandomResponseItem>()
//                for (i in 0 until (response.body()!!.size)) {
//                    arrayBaru.add(response.body()[i].randomResponse)
//                }
                listFood.value = response.body()
            }

            override fun onFailure(call: Call<List<RandomResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getResultListUser() : MutableLiveData<List<RandomResponse>> = listFood
}
