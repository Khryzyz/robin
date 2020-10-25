package com.camilorubio.robin.viewmodel.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.view.model.CompanyBind
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeViewModel @Inject constructor(private val useCases : IContractEmployee.UseCases)
    : ViewModel(), IContractEmployee.ViewModel {

    private val _companyName = MutableLiveData<String>()
    val companyName: LiveData<String>
        get() = _companyName

    private val _companyAddress = MutableLiveData<String>()
    val companyAddress: LiveData<String>
        get() = _companyAddress

    private val _employees = MutableLiveData<UIState>()
    val employees: LiveData<UIState>
        get() = _employees

    override fun getEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                useCases.getEmployees { responseState ->
                    when (responseState) {
                        is ResponseState.Success -> {
                            (responseState.data as CompanyBind).let { companyBind ->
                                _companyAddress.postValue(companyBind.address)
                                _companyName.postValue(companyBind.companyName)
                                _employees.postValue(UIState.Success(companyBind.employees))
                            }
                        }
                        is ResponseState.Error -> _employees.postValue(UIState.Error(responseState.message))
                    }
                }
            } catch (ex : Exception) {
                _employees.postValue(UIState.Error("Algo ha salido mal"))
            }
        }
    }


}