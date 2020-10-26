package com.camilorubio.robin.data.repository

import com.camilorubio.robin.data.datasource.local.EmployeeLocalDataSource
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val employeeLocalDataSource: EmployeeLocalDataSource
) : IContractEmployee.Repository {

    override suspend fun getEmployeeNewById(idEmployee: Long): EmployeeNewDB? {
        return employeeLocalDataSource.getEmployeeNewById(idEmployee)
    }

}