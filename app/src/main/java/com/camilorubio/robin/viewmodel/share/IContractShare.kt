package com.camilorubio.robin.viewmodel.share

import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind

interface IContractShare {

    interface ViewModel {
        fun setCompanyBind(companyBind: CompanyBind)
        fun getCompanyBind() : CompanyBind?
        fun getBossEmployeeById(id : Long, bossEmployeeBind: (BossEmployeeBind?) -> Unit)
    }

    interface UseCases {
        fun getBossEmployeeById(id : Long, companyBind: CompanyBind) : BossEmployeeBind?
    }

}