package com.camilorubio.robin.data.datasource.local

import com.camilorubio.robin.data.db.dao.EmployeeDao
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import javax.inject.Inject

class HomeLocalDataSourceImpl @Inject constructor(
    private val employeeDao: EmployeeDao
) : HomeLocalDataSource {

    override suspend fun insertNewEmployee(employeeNewDB: EmployeeNewDB) {
        employeeDao.insertEmployeeNew(employeeNewDB)
    }

}