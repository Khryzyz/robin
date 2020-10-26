package com.camilorubio.robin.data.datasource.remote

import com.camilorubio.robin.domain.dto.CompanyResDTO
import retrofit2.Response

interface HomeRemoteDataSource {

    suspend fun getEmployees() : Response<CompanyResDTO>

}