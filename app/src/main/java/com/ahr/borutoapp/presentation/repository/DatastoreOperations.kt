package com.ahr.borutoapp.presentation.repository

import kotlinx.coroutines.flow.Flow

interface DatastoreOperations {
    suspend fun saveOnBoardingState(state: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}