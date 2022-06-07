package com.project.recipee.data.network

import com.google.gson.annotations.SerializedName

data class ApiResponse(

    @field:SerializedName("results")
    val results : List<NetworkRecipe>

)