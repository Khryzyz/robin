package com.camilorubio.robin.data.datasource.local

import com.camilorubio.robin.domain.entity.EmployeeNewDB

interface EmployeeNewLocalDataSource {

    suspend fun getEmployeesNew() : List<EmployeeNewDB>?

}