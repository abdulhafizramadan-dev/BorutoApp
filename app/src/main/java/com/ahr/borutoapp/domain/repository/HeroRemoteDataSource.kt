package com.ahr.borutoapp.domain.repository

import androidx.paging.PagingData
import com.ahr.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface HeroRemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(name: String): Flow<PagingData<Hero>>
}