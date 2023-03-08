package com.ahr.borutoapp.data.remote

import com.ahr.borutoapp.data.remote.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoService {

    @GET("boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}