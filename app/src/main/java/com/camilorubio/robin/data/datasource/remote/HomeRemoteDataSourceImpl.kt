package com.camilorubio.robin.data.datasource.remote

import com.camilorubio.robin.domain.dto.CompanyResDTO
import com.camilorubio.robin.data.apiservice.RobinApi
import retrofit2.Response
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val robinApi: RobinApi
) : HomeRemoteDataSource {

    override suspend fun getEmployees(): Response<CompanyResDTO> = robinApi.getEmployees()

}