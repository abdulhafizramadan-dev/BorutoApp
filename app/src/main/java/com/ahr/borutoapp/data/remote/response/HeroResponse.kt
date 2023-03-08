package com.ahr.borutoapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class HeroResponse(

	@field:SerializedName("abilities")
	val abilities: List<String> = emptyList(),

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("month")
	val month: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("about")
	val about: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("power")
	val power: Int? = null,

	@field:SerializedName("family")
	val family: List<String> = emptyList(),

	@field:SerializedName("day")
	val day: String? = null,

	@field:SerializedName("natureTypes")
	val natureTypes: List<String> = emptyList()
)
