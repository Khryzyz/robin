package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.domain.entity.EmployeeNewDB
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import javax.inject.Inject

class EmployeeUseCases @Inject constructor(
    private val repository: IContractEmployee.Repository
) : IContractEmployee.UseCases {

    override suspend fun getEmployeeNewById(idEmployee: Long): EmployeeNewDB? {
        return repository.getEmployeeNewById(idEmployee)
    }

}