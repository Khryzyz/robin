package com.camilorubio.robin.data.repository

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.data.datasource.remote.EmployeeRemoteDataSource
import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.utils.Mapper.Companion.mapBossEmployeeDto
import com.camilorubio.robin.utils.Mapper.Companion.mapCompanyDto
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val employeeRemoteDataSource: EmployeeRemoteDataSource
) : IContractEmployee.Repository {

    override suspend fun getEmployees(responseState: (ResponseState) -> Unit) {
        return employeeRemoteDataSource.getEmployees().let { response ->
            if (response.isSuccessful) {
                responseState(
                    ResponseState.Success (
                        mapCompanyDto(response.body() as CompanyResDTO) { listBossEmployeeResDTO ->
                            mapBossEmployeeDto(listBossEmployeeResDTO)
                        }
                    )
                )
            } else {
                responseState(
                    ResponseState.Error ("Algo esta mal")
                )
            }
        }
    }
        
}