package com.camilorubio.robin.di.module

import com.camilorubio.robin.data.datasource.local.EmployeeLocalDataSource
import com.camilorubio.robin.data.datasource.local.EmployeeLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideEmployeeLocalDataSource(
        employeeLocalDataSource: EmployeeLocalDataSourceImpl
    ): EmployeeLocalDataSource

}