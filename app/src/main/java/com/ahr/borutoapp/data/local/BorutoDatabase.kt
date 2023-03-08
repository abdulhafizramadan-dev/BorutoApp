package com.ahr.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahr.borutoapp.data.local.dao.HeroDao
import com.ahr.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.ahr.borutoapp.domain.model.Hero
import com.ahr.borutoapp.domain.model.HeroRemoteKey

@TypeConverters(DatabaseConverter::class)
@Database(
    entities = [Hero::class, HeroRemoteKey::class],
    version = 1,
    exportSchema = false
)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

    companion object {
        const val DATABASE_NAME = "boruto_database"
        const val HERO_TABLE = "hero_table"
        const val HERO_REMOTE_KEY_TABLE = "hero_remote_key_table"
    }
}