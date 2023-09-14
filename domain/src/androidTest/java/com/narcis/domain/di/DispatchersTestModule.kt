package com.narcis.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DispatchersTestModule {
    @Provides
    fun provideDispatchers(): DefaultDispatcherProvider = DefaultDispatcherProvider()
}
