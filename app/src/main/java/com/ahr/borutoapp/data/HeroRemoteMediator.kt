package com.ahr.borutoapp.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ahr.borutoapp.data.local.BorutoDatabase
import com.ahr.borutoapp.data.local.entity.HeroEntity
import com.ahr.borutoapp.data.local.entity.HeroRemoteKeys
import com.ahr.borutoapp.data.remote.BorutoService
import com.ahr.borutoapp.data.remote.response.toEntities
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator @Inject constructor(
    private val borutoService: BorutoService,
    private val borutoDatabase: BorutoDatabase
) : RemoteMediator<Int, HeroEntity>() {

    private val heroDao get() = borutoDatabase.heroDao()
    private val heroRemoteKeysDao get() = borutoDatabase.heroRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, HeroEntity>
    ): MediatorResult {
        return try {

            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKey = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKey?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKey = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKey?.prevPage ?: return MediatorResult.Success(endOfPaginationReached = remoteKey != null)
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKey = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKey?.nextPage ?: return MediatorResult.Success(endOfPaginationReached = remoteKey != null)
                    nextPage
                }
            }

            val response = borutoService.getAllHeroes(page = page)

            if (response.data.isNotEmpty()) {
                borutoDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        heroDao.deleteAllHeroes()
                        heroRemoteKeysDao.deleteAllRemoteKeys()
                    }

                    val prevKey = response.prevPage
                    val nextKey = response.nextPage
                    val remoteKeys = response.data.map { heroResponse ->
                        HeroRemoteKeys(
                            id = heroResponse.id,
                            prevPage = prevKey,
                            nextPage = nextKey
                        )
                    }
                    heroRemoteKeysDao.insertRemoteKeys(remoteKeys = remoteKeys)

                    val heroEntities = response.data.toEntities()
                    heroDao.insertHeroes(heroEntities = heroEntities)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (exception: Exception) {
            MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, HeroEntity>): HeroRemoteKeys? {
        return state.anchorPosition?.let {  position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                heroRemoteKeysDao.getRemoteKey(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, HeroEntity>): HeroRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() } ?.data?.firstOrNull()?.id?.let { id ->
            heroRemoteKeysDao.getRemoteKey(id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, HeroEntity>): HeroRemoteKeys? {
        return state.pages.lastOrNull{ it.data.isNotEmpty() } ?.data?.firstOrNull()?.id?.let { id ->
            heroRemoteKeysDao.getRemoteKey(id)
        }
    }

}