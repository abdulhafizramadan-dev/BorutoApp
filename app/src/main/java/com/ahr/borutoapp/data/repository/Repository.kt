package com.ahr.borutoapp.data.repository

import androidx.paging.PagingData
import com.ahr.borutoapp.domain.model.Hero
import com.ahr.borutoapp.domain.repository.DatastoreOperations
import com.ahr.borutoapp.domain.repository.HeroRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val heroRemoteDataSource: HeroRemoteDataSource,
    private val dataStore: DatastoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return heroRemoteDataSource.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}