package com.camilorubio.robin.domain.datasource.remote

import com.camilorubio.robin.domain.entities.CompanyResDTO
import com.camilorubio.robin.model.remote.RobinApi
import retrofit2.Response
import javax.inject.Inject

class EmployeeRemoteDataSourceImpl @Inject constructor(
    private val robinApi: RobinApi
) : EmployeeRemoteDataSource {

    override suspend fun getEmployees(): Response<CompanyResDTO> = robinApi.getEmployees()

}