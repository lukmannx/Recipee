package com.project.recipee.data.response

import com.google.gson.annotations.SerializedName
import com.project.recipee.data.network.NetworkRecipe

data class ApiResponse(

    @field:SerializedName("results")
    val results : List<NetworkRecipe>

)