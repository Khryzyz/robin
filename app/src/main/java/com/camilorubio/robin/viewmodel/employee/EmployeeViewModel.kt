package com.camilorubio.robin.viewmodel.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeViewModel @Inject constructor(private val useCases : IContractEmployee.UseCases)
    : ViewModel(), IContractEmployee.ViewModel {

    private val _employees = MutableLiveData<UIState>()
    val employees: LiveData<UIState>
        get() = _employees

    override fun getEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                useCases.getEmployees { uiState ->
                    _employees.postValue(uiState)
                }
            } catch (ex : Exception) {
                _employees.postValue(UIState.Error("Algo ha salido mal"))
            }
        }
    }


}