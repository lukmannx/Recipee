package com.project.recipee.ui

import android.util.Log
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
    val listFood = MutableLiveData<RandomResponse>()

    fun getRandomList(){
        ApiClient.getApiService().getRandom().enqueue(object : Callback<RandomResponse> {
            override fun onResponse(
                call: Call<RandomResponse>,
                response: Response<RandomResponse>
            ) {
//                val arrayBaru = arrayListOf<RandomResponseItem>()
//                for (i in 0 until (response.body()!!.size)) {
//                    arrayBaru.add(response.body()[i].randomResponse)
//                }

                Log.d("DATA", "${response.body()?.randomResponse}")
                listFood.value = response.body()
            }

            override fun onFailure(call: Call<RandomResponse>, t: Throwable) {
                Log.i("TAG", "onFailure: $t")
            }
        })
    }

    fun getResultListUser() : LiveData<RandomResponse> = listFood
}
