package com.camilorubio.robin.viewmodel.employeenew

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilorubio.robin.view.model.EmployeeNewBind
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeNewViewModel @Inject constructor(
    private val useCases : IContractEmployeeNew.UseCases
) : ViewModel(), IContractEmployeeNew.ViewModel {

    private val _employeesNew = MutableLiveData<List<EmployeeNewBind>>()
    val employeesNew: LiveData<List<EmployeeNewBind>>
        get() = _employeesNew

    override fun getEmployeesNew() {
        viewModelScope.launch(Dispatchers.IO) {
            _employeesNew.postValue(useCases.getEmployeesNew())
        }
    }


}