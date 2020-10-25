package com.camilorubio.robin.di.module

import com.camilorubio.robin.data.datasource.remote.EmployeeRemoteDataSource
import com.camilorubio.robin.data.datasource.remote.EmployeeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideEmployeeRemoteDataSource(
        employeeRemoteDataSourceImpl: EmployeeRemoteDataSourceImpl
    ): EmployeeRemoteDataSource

}