package com.camilorubio.robin.di.module

import com.camilorubio.robin.data.datasource.remote.HomeRemoteDataSource
import com.camilorubio.robin.data.datasource.remote.HomeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideHomeRemoteDataSource(
        homeRemoteDataSourceImpl: HomeRemoteDataSourceImpl
    ): HomeRemoteDataSource

}