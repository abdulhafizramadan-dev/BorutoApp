package com.ahr.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahr.borutoapp.data.local.dao.HeroDao
import com.ahr.borutoapp.data.local.dao.HeroRemoteKeysDao
import com.ahr.borutoapp.data.local.entity.HeroEntity
import com.ahr.borutoapp.data.local.entity.HeroRemoteKeys

@TypeConverters(DatabaseConverter::class)
@Database(
    entities = [HeroEntity::class, HeroRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao

    companion object {
        const val DATABASE_NAME = "boruto_database"
        const val HERO_TABLE = "hero_table"
        const val HERO_REMOTE_KEYS_TABLE = "hero_remote_keys_table"
    }
}