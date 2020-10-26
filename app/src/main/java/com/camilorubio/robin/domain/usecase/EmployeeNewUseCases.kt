package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.view.model.EmployeeNewBind
import com.camilorubio.robin.viewmodel.employeenew.IContractEmployeeNew
import javax.inject.Inject

class EmployeeNewUseCases @Inject constructor(
    private val repository: IContractEmployeeNew.Repository
) : IContractEmployeeNew.UseCases {

    override suspend fun getEmployeesNew(): List<EmployeeNewBind>? {
        return repository.getEmployeesNew()
    }

}