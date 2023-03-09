package com.ahr.borutoapp.data.remote.response

import com.ahr.borutoapp.data.local.entity.HeroEntity
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
	val id: Int,

	@field:SerializedName("power")
	val power: Int? = null,

	@field:SerializedName("family")
	val family: List<String> = emptyList(),

	@field:SerializedName("day")
	val day: String? = null,

	@field:SerializedName("natureTypes")
	val natureTypes: List<String> = emptyList()
)


fun List<HeroResponse>.toEntities(): List<HeroEntity> {
	return map { hero -> hero.toEntity() }
}
fun HeroResponse.toEntity(): HeroEntity {
	return HeroEntity(
		id = id,
		name = name ?: "",
		image = image ?: "",
		about = about ?:"",
		rating = rating ?: 0.0,
		power = power ?: 0,
		month = month ?: "",
		day = day ?: "",
		family = family,
		abilities = abilities,
		natureTypes = natureTypes
	)
}