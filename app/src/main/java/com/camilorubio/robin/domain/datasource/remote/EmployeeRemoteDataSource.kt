package com.camilorubio.robin.domain.datasource.remote

import com.camilorubio.robin.domain.entities.CompanyResDTO
import retrofit2.Response

interface EmployeeRemoteDataSource {

    suspend fun getEmployees() : Response<CompanyResDTO>

}