package com.camilorubio.robin.di.module

import com.camilorubio.robin.domain.usecase.EmployeeUseCases
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UseCasesModule {

    @Binds
    @Singleton
    abstract fun provideEmployeeUseCases(employeeUseCases: EmployeeUseCases): IContractEmployee.UseCases

}