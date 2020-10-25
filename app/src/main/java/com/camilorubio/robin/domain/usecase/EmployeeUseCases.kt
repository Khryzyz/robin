package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import javax.inject.Inject

class EmployeeUseCases @Inject constructor(private val repository: IContractEmployee.Repository) : IContractEmployee.UseCases {

    override suspend fun getEmployees(responseState : (ResponseState) -> Unit) {
        repository.getEmployees {
            responseState(it)
        }
    }

}