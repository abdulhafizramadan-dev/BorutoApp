package com.ahr.borutoapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahr.borutoapp.data.local.BorutoDatabase
import com.ahr.borutoapp.domain.model.Hero

@Entity(tableName = BorutoDatabase.HERO_TABLE)
data class HeroEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
)

fun HeroEntity.toDomain(): Hero {
    return Hero(
        id = id,
        name = name,
        image = image,
        about = about,
        rating = rating,
        power = power,
        month = month,
        day = day,
        family = family,
        abilities = abilities,
        natureTypes = natureTypes
    )
}
