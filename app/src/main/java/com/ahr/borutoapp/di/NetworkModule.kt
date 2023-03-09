package com.ahr.borutoapp.di

import com.ahr.borutoapp.data.local.BorutoDatabase
import com.ahr.borutoapp.data.remote.BorutoService
import com.ahr.borutoapp.data.repository.HeroRemoteDataSourceImpl
import com.ahr.borutoapp.domain.repository.HeroRemoteDataSource
import com.ahr.borutoapp.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBorutoService(
        retrofit: Retrofit
    ): BorutoService {
        return retrofit.create(BorutoService::class.java)
    }

    @Provides
    @Singleton
    fun provideHeroRemoteDataSource(
        borutoService: BorutoService,
        borutoDatabase: BorutoDatabase
    ): HeroRemoteDataSource {
        return HeroRemoteDataSourceImpl(
            borutoService, borutoDatabase
        )
    }
}