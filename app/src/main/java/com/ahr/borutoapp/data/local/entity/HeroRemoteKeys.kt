package com.ahr.borutoapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahr.borutoapp.data.local.BorutoDatabase

@Entity(BorutoDatabase.HERO_REMOTE_KEYS_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
)
