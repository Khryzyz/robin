package com.camilorubio.robin.viewmodel.employee

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.view.model.CompanyBind
import retrofit2.Response

interface IContractEmployee {

    interface ViewModel {
        fun getEmployees()
    }

    interface UseCases {
        suspend fun getEmployees(responseState: (ResponseState) -> Unit)
    }

    interface Repository {
        suspend fun getEmployees(responseState: (ResponseState) -> Unit)
    }

}