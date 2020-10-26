package com.camilorubio.robin.di.module

import com.camilorubio.robin.data.datasource.local.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideHomeLocalDataSource(
        homeLocalDataSource: HomeLocalDataSourceImpl
    ): HomeLocalDataSource

    @Binds
    @Singleton
    abstract fun provideEmployeeLocalDataSource(
        employeeLocalDataSource: EmployeeLocalDataSourceImpl
    ): EmployeeLocalDataSource

    @Binds
    @Singleton
    abstract fun provideEmployeeNewLocalDataSource(
        employeeNewLocalDataSource: EmployeeNewLocalDataSourceImpl
    ): EmployeeNewLocalDataSource

}