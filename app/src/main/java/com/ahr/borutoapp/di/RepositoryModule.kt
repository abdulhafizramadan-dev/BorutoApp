package com.ahr.borutoapp.di

import android.content.Context
import com.ahr.borutoapp.data.pref.DatastoreOperationsImpl
import com.ahr.borutoapp.presentation.repository.DatastoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDatastoreOperations(
        @ApplicationContext context: Context
    ): DatastoreOperations {
        return DatastoreOperationsImpl(context)
    }
}