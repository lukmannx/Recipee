package com.project.recipee.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SearchResponse(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

@Parcelize
data class ResultsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
) : Parcelable
