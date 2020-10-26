package com.camilorubio.robin.viewmodel.home

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind

interface IContractHome {

    interface ViewModel {
        fun getEmployees()
        fun getCompany() : CompanyBind?
        fun setItemsSelectable(status : Boolean)
        fun setStatusCheckByEmployee(idEmployee : Long, status : Boolean)
        fun cleanSelection()
        fun saveEmployeesAsNew()
        fun filterListEmployees(newText : String)
        fun sortList()
    }

    interface UseCases {
        suspend fun getEmployees(responseState: (ResponseState) -> Unit)
        fun setItemsSelectable(status : Boolean, listBossEmployeeBind: List<BossEmployeeBind>) : List<BossEmployeeBind>
        fun cleanSelection(listBossEmployeeBind: List<BossEmployeeBind>) : List<BossEmployeeBind>
        fun setStatusCheckByEmployee(idEmployee: Long, status : Boolean, listBossEmployeeBind: List<BossEmployeeBind>) : List<BossEmployeeBind>
        suspend fun saveEmployeesAsNew(listBossEmployeeBind: List<BossEmployeeBind>)
        fun filterListEmployees(newText : String, listBossEmployeeBind: List<BossEmployeeBind>) : List<BossEmployeeBind>?
        fun sortList(listBossEmployeeBind: List<BossEmployeeBind>) : List<BossEmployeeBind>?
    }

    interface Repository {
        suspend fun getEmployees(responseState: (ResponseState) -> Unit)
        suspend fun saveEmployeesAsNew(employeeNewDB: EmployeeNewDB)
    }

}