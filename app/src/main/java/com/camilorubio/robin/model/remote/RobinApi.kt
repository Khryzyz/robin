package com.camilorubio.robin.model.remote

import com.camilorubio.robin.domain.entities.CompanyResDTO
import com.camilorubio.robin.utils.Constants.RobinApi.EMPLOYEES
import retrofit2.Response
import retrofit2.http.GET

interface RobinApi {

    @GET(EMPLOYEES)
    suspend fun getEmployees() : Response<CompanyResDTO>

}