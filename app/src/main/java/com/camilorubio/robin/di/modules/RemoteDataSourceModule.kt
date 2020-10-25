package com.camilorubio.robin.di.modules

import com.camilorubio.robin.domain.datasource.remote.EmployeeRemoteDataSource
import com.camilorubio.robin.domain.datasource.remote.EmployeeRemoteDataSourceImpl
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