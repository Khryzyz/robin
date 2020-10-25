package com.camilorubio.robin.domain.usecases

import com.camilorubio.robin.domain.entities.CompanyResDTO
import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import com.camilorubio.robin.viewmodel.employee.UIState
import javax.inject.Inject

class EmployeeUseCases @Inject constructor(private val repository: IContractEmployee.Repository) : IContractEmployee.UseCases {

    override suspend fun getEmployees(uiState: (UIState) -> Unit) {
        repository.getEmployees().let { response ->
            if (response.isSuccessful)
                uiState(UIState.Success(response.body() as CompanyResDTO))
            else
                uiState(UIState.Error("Error parseo"))
        }
    }

}