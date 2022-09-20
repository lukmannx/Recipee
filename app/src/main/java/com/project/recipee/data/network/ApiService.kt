package com.project.recipee.data.network

import com.project.recipee.BuildConfig
import com.project.recipee.data.response.MealplannerResponse
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/recipes/complexSearch")
    fun getRecipes(
        @Query("query") query: String,
        @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
        @Query("number") number: Int = 20,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Call<SearchResponse>

    @GET("recipes/random")
    fun getRandom(
        @Query("number") number: Int = 30,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Call<RandomResponse>

    @GET("mealplanner/generate")
    fun getMealPlan(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ) : Call<MealplannerResponse>

}
