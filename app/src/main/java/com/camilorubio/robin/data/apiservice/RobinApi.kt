package com.camilorubio.robin.data.apiservice

import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.utility.Constants.RobinApi.EMPLOYEES
import retrofit2.Response
import retrofit2.http.GET

interface RobinApi {

    @GET(EMPLOYEES)
    suspend fun getEmployees() : Response<CompanyResDTO>

}