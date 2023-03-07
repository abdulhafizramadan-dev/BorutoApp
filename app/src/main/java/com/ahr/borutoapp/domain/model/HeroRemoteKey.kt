package com.ahr.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahr.borutoapp.data.BorutoDatabase

@Entity(BorutoDatabase.HERO_REMOTE_KEY_TABLE)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
)
