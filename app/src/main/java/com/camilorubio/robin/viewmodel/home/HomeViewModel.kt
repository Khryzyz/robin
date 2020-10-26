package com.camilorubio.robin.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilorubio.robin.R
import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind
import com.camilorubio.robin.viewmodel.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val useCases : IContractHome.UseCases)
    : ViewModel(), IContractHome.ViewModel {

    private val _company = MutableLiveData<CompanyBind>()
    val company: LiveData<CompanyBind>
        get() = _company

    private val _companyName = MutableLiveData<String>()
    val companyName: LiveData<String>
        get() = _companyName

    private val _companyAddress = MutableLiveData<String>()
    val companyAddress: LiveData<String>
        get() = _companyAddress

    private val _bossEmployees = MutableLiveData<UIState>()
    val bossEmployees: LiveData<UIState>
        get() = _bossEmployees

    override fun getEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                useCases.getEmployees { responseState ->
                    when (responseState) {
                        is ResponseState.Success -> {
                            (responseState.data as CompanyBind).let { companyBind ->
                                _company.postValue(companyBind)
                                _companyAddress.postValue(companyBind.address)
                                _companyName.postValue(companyBind.companyName)
                                _bossEmployees.postValue(UIState.Success(companyBind.employees))
                            }
                        }
                        is ResponseState.Error -> _bossEmployees.postValue(UIState.Error(responseState.message))
                    }
                }
            } catch (ex : Exception) {
                _bossEmployees.postValue(UIState.Error(R.string.text_error))
            }
        }
    }

    override fun getCompany(): CompanyBind? {
        return  _company.value
    }

    override fun setItemsSelectable(status : Boolean) {
        getCompany()?.let { companyBind ->
            useCases.setItemsSelectable(status, companyBind.employees).let { listBossEmployeeBind ->
                _bossEmployees.value = UIState.Success(
                    listBossEmployeeBind
                )
                _company.value?.employees = listBossEmployeeBind
            }
        }
    }

    override fun setStatusCheckByEmployee(idEmployee: Long, status: Boolean) {
        getCompany()?.let { companyBind ->
            useCases.setStatusCheckByEmployee(idEmployee, status, companyBind.employees).let { listBossEmployeeBind ->
                _bossEmployees.value = UIState.Success(
                    listBossEmployeeBind
                )
                _company.value?.employees = listBossEmployeeBind
            }
        }
    }

    override fun cleanSelection() {
        getCompany()?.let { companyBind ->
            useCases.cleanSelection(companyBind.employees).let { listBossEmployeeBind ->
                _bossEmployees.value = UIState.Success(
                    listBossEmployeeBind
                )
                _company.value?.employees = listBossEmployeeBind
            }
        }
    }

    override fun saveEmployeesAsNew() {
        viewModelScope.launch(Dispatchers.IO) {
            getCompany()?.let { companyBind ->
                useCases.saveEmployeesAsNew(companyBind.employees)
            }
        }
    }

    override fun filterListEmployees(newtext: String) {
        getCompany()?.let { companyBind ->
            useCases.filterListEmployees(newtext, companyBind.employees)?.let { listBossEmployeeBind ->
                _bossEmployees.value = UIState.Success(
                    listBossEmployeeBind
                )
            }
        }
    }

}