package com.ahr.borutoapp.di

import android.content.Context
import androidx.room.Room
import com.ahr.borutoapp.data.BorutoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBorutoDatabase(
        @ApplicationContext context: Context
    ) : BorutoDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = BorutoDatabase::class.java,
            name = BorutoDatabase.DATABASE_NAME
        ).build()
    }
}