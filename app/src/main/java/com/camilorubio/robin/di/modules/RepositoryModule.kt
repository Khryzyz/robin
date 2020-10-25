package com.camilorubio.robin.di.modules

import com.camilorubio.robin.domain.repositories.EmployeeRepository
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