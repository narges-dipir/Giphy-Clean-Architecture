package com.narcis.domain.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultDispatcherProvider {
    val main: CoroutineDispatcher get() = Dispatchers.Main
    val default: CoroutineDispatcher get() = Dispatchers.Default
    val io: CoroutineDispatcher get() = Dispatchers.IO
    val unconfined: CoroutineDispatcher get() = Dispatchers.Unconfined
}