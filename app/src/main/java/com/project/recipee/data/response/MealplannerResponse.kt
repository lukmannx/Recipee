package com.project.recipee.data.response

import com.google.gson.annotations.SerializedName

data class MealplannerResponse(

	@field:SerializedName("week")
	val week: Week? = null
)

data class Nutrients(

	@field:SerializedName("carbohydrates")
	val carbohydrates: Double? = null,

	@field:SerializedName("protein")
	val protein: Double? = null,

	@field:SerializedName("fat")
	val fat: Double? = null,

	@field:SerializedName("calories")
	val calories: Double? = null
)

data class Week(

	@field:SerializedName("sunday")
	val sunday: Sunday? = null,

	@field:SerializedName("saturday")
	val saturday: Saturday? = null,

	@field:SerializedName("tuesday")
	val tuesday: Tuesday? = null,

	@field:SerializedName("wednesday")
	val wednesday: Wednesday? = null,

	@field:SerializedName("thursday")
	val thursday: Thursday? = null,

	@field:SerializedName("friday")
	val friday: Friday? = null,

	@field:SerializedName("monday")
	val monday: Monday? = null
)

data class Friday(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)

data class MealsItem(

	@field:SerializedName("readyInMinutes")
	val readyInMinutes: Int? = null,

	@field:SerializedName("sourceUrl")
	val sourceUrl: String? = null,

	@field:SerializedName("servings")
	val servings: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("imageType")
	val imageType: String? = null
)

data class Sunday(

	@field:SerializedName("meals")
	val meals: List<MealsItem>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)

data class Wednesday(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)

data class Monday(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)

data class Tuesday(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)

data class Saturday(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)

data class Thursday(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null,

	@field:SerializedName("nutrients")
	val nutrients: Nutrients? = null
)
