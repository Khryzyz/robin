package com.camilorubio.robin.di.modules

import com.camilorubio.robin.domain.usecases.EmployeeUseCases
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