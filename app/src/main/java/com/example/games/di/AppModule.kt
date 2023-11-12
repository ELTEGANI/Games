package com.example.games.di

import com.example.games.core.utils.Constants.BASE_URL
import com.example.games.data.FreeGamesApi
import com.example.games.data.repository.FreeGamesRepositoryImp
import com.example.games.domain.repositry.FreeGameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideFreeGameApi(retrofit: Retrofit):FreeGamesApi = retrofit.create(FreeGamesApi::class.java)


    @Provides
    @Singleton
    fun provideFreeGameRepository(freeGamesApi: FreeGamesApi):FreeGameRepository{
        return FreeGamesRepositoryImp(freeGamesApi)
    }
}