package com.project.recipee.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RandomResponse(
	@field:SerializedName("instructions")
	val instructions: String? = null,

	@field:SerializedName("title")
	val title: String? = null,



	@field:SerializedName("readyInMinutes")
	val readyInMinutes: Int? = null,

	@field:SerializedName("sourceUrl")
	val sourceUrl: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("imageType")
	val imageType: String? = null,

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("cookingMinutes")
	val cookingMinutes: Int? = null,

	@field:SerializedName("image")
	val image: String? = null,
) : Parcelable

//@Parcelize
//data class RandomResponse(
//
//	@field:SerializedName("recipes")
//	val recipes: List<RecipesItem?>? = null
//) : Parcelable
//
//@Parcelize
//
//data class RecipesItem(
//
//	@field:SerializedName("instructions")
//	val instructions: String? = null,
//
//	@field:SerializedName("analyzedInstructions")
//	val analyzedInstructions: List<AnalyzedInstructionsItem?>? = null,
//
//	@field:SerializedName("title")
//	val title: String? = null,
//
//	@field:SerializedName("readyInMinutes")
//	val readyInMinutes: Int? = null,
//
//	@field:SerializedName("sourceUrl")
//	val sourceUrl: String? = null,
//
//	@field:SerializedName("id")
//	val id: Int? = null,
//
//	@field:SerializedName("imageType")
//	val imageType: String? = null,
//
//	@field:SerializedName("summary")
//	val summary: String? = null,
//
//	@field:SerializedName("cookingMinutes")
//	val cookingMinutes: Int? = null,
//
//	@field:SerializedName("image")
//	val image: String? = null,
//
//) : Parcelable
//
//@Parcelize
//data class AnalyzedInstructionsItem(
//
//	@field:SerializedName("name")
//	val name: String? = null,
//
//	@field:SerializedName("steps")
//	val steps: List<StepsItem?>? = null
//) : Parcelable
//
//@Parcelize
//data class EquipmentItem(
//
//	@field:SerializedName("image")
//	val image: String? = null,
//
//	@field:SerializedName("localizedName")
//	val localizedName: String? = null,
//
//	@field:SerializedName("name")
//	val name: String? = null,
//
//	@field:SerializedName("id")
//	val id: Int? = null
//) : Parcelable
//
//@Parcelize
//data class Length(
//
//	@field:SerializedName("number")
//	val number: Int? = null,
//
//	@field:SerializedName("unit")
//	val unit: String? = null
//) : Parcelable
//
//@Parcelize
//data class StepsItem(
//
//	@field:SerializedName("number")
//	val number: Int? = null,
//
//	@field:SerializedName("length")
//	val length: Length? = null,
//
//	@field:SerializedName("equipment")
//	val equipment: List<EquipmentItem?>? = null,
//
//	@field:SerializedName("step")
//	val step: String? = null
//) : Parcelable
