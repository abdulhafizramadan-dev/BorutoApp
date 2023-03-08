package com.ahr.borutoapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("nextPage")
	val nextPage: Int? = null,

	@field:SerializedName("prevPage")
	val prevPage: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("data")
	val data: List<HeroResponse> = emptyList()
)
