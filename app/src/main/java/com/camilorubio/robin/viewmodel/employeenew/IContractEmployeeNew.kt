package com.camilorubio.robin.viewmodel.employeenew

import com.camilorubio.robin.view.model.EmployeeNewBind

interface IContractEmployeeNew {

    interface ViewModel {
        fun getEmployeesNew()
    }

    interface UseCases {
        suspend fun getEmployeesNew() : List<EmployeeNewBind>?
    }

    interface Repository {
        suspend fun getEmployeesNew() : List<EmployeeNewBind>?
    }

}