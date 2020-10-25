package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind
import com.camilorubio.robin.viewmodel.share.IContractShare
import javax.inject.Inject

class ShareUseCases @Inject constructor() : IContractShare.UseCases {

    override fun getBossEmployeeById(id: Long, companyBind: CompanyBind): BossEmployeeBind? {
        return companyBind.employees.find { bossEmployeeBind ->
            bossEmployeeBind.id == id
        }
    }

}