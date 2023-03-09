package com.ahr.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DatastoreOperations {
    suspend fun saveOnBoardingState(state: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}