package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.viewmodel.employee.IContractEmployee
import javax.inject.Inject

class EmployeeUseCases @Inject constructor(
    private val repository: IContractEmployee.Repository
) : IContractEmployee.UseCases {

}