package com.project.recipee.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.recipee.data.network.ApiClient
import com.project.recipee.data.response.MealplannerResponse
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.RandomResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listFood = MutableLiveData<RandomResponse>()
    val listMeal= MutableLiveData<MealplannerResponse>()

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


    fun getRandomMeal(){
        ApiClient.getApiService().getMealPlan().enqueue(object : Callback<MealplannerResponse>{
            override fun onResponse(
                call: Call<MealplannerResponse>,
                response: Response<MealplannerResponse>
            ) {
                listMeal.value = response.body()
            }

            override fun onFailure(call: Call<MealplannerResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getResultListFood() : LiveData<RandomResponse> = listFood
    fun getResultListMeal() : LiveData<MealplannerResponse> = listMeal

}
