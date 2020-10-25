package com.camilorubio.robin.domain.repositories

import com.camilorubio.robin.domain.datasource.remote.EmployeeRemoteDataSource
import com.camilorubio.robin.domain.entities.CompanyResDTO
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import retrofit2.Response
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val employeeRemoteDataSource: EmployeeRemoteDataSource
) : IContractEmployee.Repository {

    override suspend fun getEmployees(): Response<CompanyResDTO> = employeeRemoteDataSource.getEmployees()

}