package com.project.recipee.data.network

import com.project.recipee.BuildConfig
import com.project.recipee.data.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.nio.channels.spi.AbstractSelectionKey

interface ApiService {

    @GET("/recipes/complexSearch")
    fun getRecipes(
        @Query("query") query: String,
        @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
        @Query("number") number: Int = 20,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): SearchResponse

    @GET("/recipes/random")
    fun getRandom(
        @Query("number") number: Int = 30,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    )
}
