package com.camilorubio.robin.viewmodel.home

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.view.model.CompanyBind
import retrofit2.Response

interface IContractHome {

    interface ViewModel {
        fun getEmployees()
        fun getCompany() : CompanyBind?
    }

    interface UseCases {
        suspend fun getEmployees(responseState: (ResponseState) -> Unit)
    }

    interface Repository {
        suspend fun getEmployees(responseState: (ResponseState) -> Unit)
    }

}