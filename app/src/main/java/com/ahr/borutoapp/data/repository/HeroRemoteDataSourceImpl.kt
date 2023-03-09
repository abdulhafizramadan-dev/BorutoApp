package com.ahr.borutoapp.data.repository

import androidx.paging.*
import com.ahr.borutoapp.data.HeroRemoteMediator
import com.ahr.borutoapp.data.local.BorutoDatabase
import com.ahr.borutoapp.data.local.entity.toDomain
import com.ahr.borutoapp.data.remote.BorutoService
import com.ahr.borutoapp.domain.model.Hero
import com.ahr.borutoapp.domain.repository.HeroRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteDataSourceImpl(
    private val borutoService: BorutoService,
    private val borutoDatabase: BorutoDatabase,
) : HeroRemoteDataSource {
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            remoteMediator = HeroRemoteMediator(borutoService, borutoDatabase),
            pagingSourceFactory = { borutoDatabase.heroDao().getAllHeroes() }
        ).flow.map { pagingData ->
            pagingData.map { heroEntity ->
                heroEntity.toDomain()
            }
        }
    }

    override fun searchHeroes(name: String): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}