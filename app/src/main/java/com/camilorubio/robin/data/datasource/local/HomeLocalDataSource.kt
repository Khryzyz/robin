package com.camilorubio.robin.data.datasource.local

import com.camilorubio.robin.domain.entity.EmployeeNewDB

interface HomeLocalDataSource {

    suspend fun insertNewEmployee(employeeNewDB: EmployeeNewDB)

}