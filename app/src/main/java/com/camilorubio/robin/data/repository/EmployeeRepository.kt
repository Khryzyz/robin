package com.camilorubio.robin.data.repository

import com.camilorubio.robin.data.datasource.local.EmployeeLocalDataSource
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val employeeLocalDataSource: EmployeeLocalDataSource
) : IContractEmployee.Repository {

}