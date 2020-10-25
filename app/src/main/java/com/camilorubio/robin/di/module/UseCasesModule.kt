package com.camilorubio.robin.di.module

import com.camilorubio.robin.domain.usecase.EmployeeUseCases
import com.camilorubio.robin.domain.usecase.HomeUseCases
import com.camilorubio.robin.domain.usecase.ShareUseCases
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import com.camilorubio.robin.viewmodel.home.IContractHome
import com.camilorubio.robin.viewmodel.share.IContractShare
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UseCasesModule {

    @Binds
    @Singleton
    abstract fun provideHomeUseCases(homeUseCases: HomeUseCases): IContractHome.UseCases

    @Binds
    @Singleton
    abstract fun provideShareUseCases(shareUseCases: ShareUseCases): IContractShare.UseCases

    @Binds
    @Singleton
    abstract fun provideEmployeeUseCases(employeeUseCases: EmployeeUseCases): IContractEmployee.UseCases

}