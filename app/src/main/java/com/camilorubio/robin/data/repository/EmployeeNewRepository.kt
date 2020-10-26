package com.camilorubio.robin.data.repository

import com.camilorubio.robin.data.datasource.local.EmployeeNewLocalDataSource
import com.camilorubio.robin.utility.Mapper.Companion.mapEmployeeDB
import com.camilorubio.robin.view.model.EmployeeNewBind
import com.camilorubio.robin.viewmodel.employeenew.IContractEmployeeNew
import javax.inject.Inject

class EmployeeNewRepository @Inject constructor(
    private val employeeNewLocalDataSource: EmployeeNewLocalDataSource
) : IContractEmployeeNew.Repository {

    override suspend fun getEmployeesNew(): List<EmployeeNewBind>? {
        return employeeNewLocalDataSource.getEmployeesNew()?.let { listEmployeeNewDB ->
            mapEmployeeDB(listEmployeeNewDB)
        } ?: run {
            listOf()
        }
    }

}