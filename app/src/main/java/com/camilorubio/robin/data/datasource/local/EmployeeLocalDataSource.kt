package com.camilorubio.robin.data.datasource.local

import com.camilorubio.robin.domain.entity.EmployeeNewDB

interface EmployeeLocalDataSource {

    suspend fun getEmployeeNewById(idEmployee : Long) : EmployeeNewDB?

}