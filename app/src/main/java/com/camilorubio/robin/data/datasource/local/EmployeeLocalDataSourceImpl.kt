package com.camilorubio.robin.data.datasource.local

import com.camilorubio.robin.data.db.dao.EmployeeDao
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import javax.inject.Inject

class EmployeeLocalDataSourceImpl @Inject constructor(
    private val employeeDao: EmployeeDao
) : EmployeeLocalDataSource {

    override suspend fun getEmployeeNewById(idEmployee: Long) : EmployeeNewDB? {
        return employeeDao.getEmployeeNewById(idEmployee)
    }


}