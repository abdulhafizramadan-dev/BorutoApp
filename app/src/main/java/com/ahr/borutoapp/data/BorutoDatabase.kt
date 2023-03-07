package com.ahr.borutoapp.data

import androidx.room.Database
import com.ahr.borutoapp.data.dao.HeroDao
import com.ahr.borutoapp.data.dao.HeroRemoteKeyDao
import com.ahr.borutoapp.domain.model.Hero
import com.ahr.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class BorutoDatabase {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

    companion object {
        const val HERO_TABLE = "hero_table"
        const val HERO_REMOTE_KEY_TABLE = "hero_remote_key_table"
    }
}