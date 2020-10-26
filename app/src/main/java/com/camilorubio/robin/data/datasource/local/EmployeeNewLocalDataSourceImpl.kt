package com.camilorubio.robin.data.datasource.local

import com.camilorubio.robin.data.db.dao.EmployeeDao
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import javax.inject.Inject

class EmployeeNewLocalDataSourceImpl @Inject constructor(
    private val employeeDao: EmployeeDao
) : EmployeeNewLocalDataSource {

    override suspend fun getEmployeesNew(): List<EmployeeNewDB>? {
        return employeeDao.getEmployeesNew()
    }

}