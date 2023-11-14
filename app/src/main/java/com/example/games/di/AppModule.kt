package com.example.games.di

import com.example.games.core.utils.Constants.BASE_URL
import com.example.games.data.FreeGamesApi
import com.example.games.data.repository.FreeGamesRepositoryImp
import com.example.games.domain.repositry.FreeGameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        val httpInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpInterceptor)
        }
        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFreeGameApi(retrofit: Retrofit):FreeGamesApi =
        retrofit.create(FreeGamesApi::class.java)


    @Provides
    @Singleton
    fun provideFreeGameRepository(freeGamesApi: FreeGamesApi):FreeGameRepository{
        return FreeGamesRepositoryImp(freeGamesApi)
    }
}