package com.camilorubio.robin.viewmodel.employee

import com.camilorubio.robin.domain.entities.CompanyResDTO
import retrofit2.Response

interface IContractEmployee {

    interface ViewModel {
        fun getEmployees()
    }

    interface UseCases {
        suspend fun getEmployees(uiState: (UIState) -> Unit)
    }

    interface Repository {
        suspend fun getEmployees() : Response<CompanyResDTO>
    }

}