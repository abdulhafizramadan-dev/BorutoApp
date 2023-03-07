package com.ahr.borutoapp.data

import androidx.room.Database
import com.ahr.borutoapp.data.dao.HeroDao
import com.ahr.borutoapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class BorutoDatabase {

    abstract fun heroDao(): HeroDao

    companion object {
        const val HERO_TABLE = "hero_table"
    }
}