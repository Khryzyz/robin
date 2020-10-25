package com.camilorubio.robin.data.datasource.remote

import com.camilorubio.robin.domain.entity.CompanyResDTO
import retrofit2.Response

interface EmployeeRemoteDataSource {

    suspend fun getEmployees() : Response<CompanyResDTO>

}