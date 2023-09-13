package com.narcis.data.di

import com.narcis.data.repository.GifRepository
import com.narcis.data.repository.GifRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindGifRepository(gifRepositoryImpl: GifRepositoryImpl): GifRepository
}
