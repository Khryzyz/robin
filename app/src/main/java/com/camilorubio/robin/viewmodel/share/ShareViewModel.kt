package com.camilorubio.robin.viewmodel.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind
import timber.log.Timber
import javax.inject.Inject

class ShareViewModel @Inject constructor(
    private val useCases: IContractShare.UseCases
) : ViewModel(), IContractShare.ViewModel {

    private val _company = MutableLiveData<CompanyBind>()
    val company: LiveData<CompanyBind>
        get() = _company

    override fun setCompanyBind(companyBind: CompanyBind) {
        _company.value = companyBind
    }

    override fun getCompanyBind(): CompanyBind? {
        return _company.value
    }

    override fun getBossEmployeeById(
        id: Long,
        bossEmployeeBind: (BossEmployeeBind?) -> Unit
    ) {
        getCompanyBind()?.let { companyBind ->
            bossEmployeeBind(
                useCases.getBossEmployeeById(id, companyBind)
            )
        }
    }


}