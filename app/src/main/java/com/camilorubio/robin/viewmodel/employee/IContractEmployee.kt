package com.camilorubio.robin.viewmodel.employee

import com.camilorubio.robin.domain.entity.EmployeeNewDB
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.EmployeeBind

interface IContractEmployee {

    interface ViewModel {
        fun setInformationBossEmployee(bossEmployeeBind: BossEmployeeBind)
        fun setBossName(name : String)
        fun setBossWage(wage : Long)
        fun setBossPosition(position : String)
        fun setListEmployees(listEmployees : List<EmployeeBind>)
        fun getEmployeeNewById(idEmployee : Long)
    }

    interface UseCases {
        suspend fun getEmployeeNewById(idEmployee : Long) : EmployeeNewDB?
    }

    interface Repository {
        suspend fun getEmployeeNewById(idEmployee : Long) : EmployeeNewDB?
    }

}