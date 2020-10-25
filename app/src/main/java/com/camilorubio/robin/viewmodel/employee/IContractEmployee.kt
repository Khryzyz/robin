package com.camilorubio.robin.viewmodel.employee

import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.EmployeeBind

interface IContractEmployee {

    interface ViewModel {
        fun setInformationBossEmployee(bossEmployeeBind: BossEmployeeBind)
        fun setBossName(name : String)
        fun setBossWage(wage : Long)
        fun setBossPosition(position : String)
        fun setListEmployees(listEmployees : List<EmployeeBind>)
    }

    interface UseCases {

    }

    interface Repository {

    }

}