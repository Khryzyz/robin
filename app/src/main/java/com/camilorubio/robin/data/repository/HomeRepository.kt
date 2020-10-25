package com.camilorubio.robin.data.repository

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.data.datasource.remote.HomeRemoteDataSource
import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.utility.Mapper.Companion.mapBossEmployeeDto
import com.camilorubio.robin.utility.Mapper.Companion.mapCompanyDto
import com.camilorubio.robin.utility.Mapper.Companion.mapEmployeeDto
import com.camilorubio.robin.viewmodel.home.IContractHome
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : IContractHome.Repository {

    override suspend fun getEmployees(responseState: (ResponseState) -> Unit) {
        return homeRemoteDataSource.getEmployees().let { response ->
            if (response.isSuccessful) {
                responseState(
                    ResponseState.Success (
                        mapCompanyDto(response.body() as CompanyResDTO) { listBossEmployeeResDTO ->
                            mapBossEmployeeDto(listBossEmployeeResDTO) { listEmployeeResDTO ->
                                mapEmployeeDto(listEmployeeResDTO)
                            }
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