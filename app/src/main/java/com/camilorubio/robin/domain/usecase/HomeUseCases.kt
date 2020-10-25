package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.viewmodel.home.IContractHome
import javax.inject.Inject

class HomeUseCases @Inject constructor(private val repository: IContractHome.Repository) : IContractHome.UseCases {

    override suspend fun getEmployees(responseState : (ResponseState) -> Unit) {
        repository.getEmployees {
            responseState(it)
        }
    }

}