package com.camilorubio.robin.di.module

import com.camilorubio.robin.data.repository.EmployeeRepository
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideEmployeeRepository(
        employeeRepository: EmployeeRepository
    ): IContractEmployee.Repository

}