package com.ahr.borutoapp.di

import android.content.Context
import com.ahr.borutoapp.data.repository.DatastoreOperationsImpl
import com.ahr.borutoapp.data.repository.Repository
import com.ahr.borutoapp.domain.usecase.UseCases
import com.ahr.borutoapp.domain.usecase.read_onboarding.ReadOnBoardingUseCase
import com.ahr.borutoapp.domain.usecase.save_onboarding.SaveOnBoardingUseCase
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

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository)
        )
    }
}