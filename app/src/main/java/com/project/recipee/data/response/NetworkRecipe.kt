package com.project.recipee.data.network

import com.google.gson.annotations.SerializedName

data class NetworkRecipe(
    val id: Int,
    val sourceName: String?,
    val title: String,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceUrl: String?,

    @SerializedName("image")
    val imageUrl: String,
    val summary: String?,

    @SerializedName("spoonacularScore")
    val score: Float?,

    @SerializedName("analyzedInstructions")
    val instructions: List<NetworkInstructions>?,

    @SerializedName("extendedIngredients")
    val ingredients: List<NetworkIngredient>?

)

data class NetworkInstructions(
    val steps: List<NetworkStep>
)

data class NetworkStep(
    val number: Int,
    val step: String,
    val ingredients: List<NetworkRecipeElement>,
    val equipment: List<NetworkRecipeElement>
)

data class NetworkRecipeElement(
    val id: Int,
    val name: String,
    val image: String
)

data class NetworkIngredient(
    val id: Int,
    val name: String,
    val original: String,
    val amount: Float,
    val unit: String
)
