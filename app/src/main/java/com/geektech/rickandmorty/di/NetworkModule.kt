package com.geektech.rickandmorty.di

import com.geektech.rickandmorty.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiServices() = retrofitClient.provideCharacterApiServices()

    @Singleton
    @Provides
    fun provideLocationApiServices() = retrofitClient.provideLocationApiServices()
}