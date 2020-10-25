package com.camilorubio.robin.data.datasource.remote

import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.data.apiservice.RobinApi
import retrofit2.Response
import javax.inject.Inject

class EmployeeRemoteDataSourceImpl @Inject constructor(
    private val robinApi: RobinApi
) : EmployeeRemoteDataSource {

    override suspend fun getEmployees(): Response<CompanyResDTO> = robinApi.getEmployees()

}