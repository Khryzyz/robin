package com.camilorubio.robin.viewmodel.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.EmployeeBind
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeViewModel @Inject constructor(
    private val useCases: IContractEmployee.UseCases
) : ViewModel(), IContractEmployee.ViewModel {

    private val _bossEmployeeName = MutableLiveData<String>()
    val bossEmployeeName: LiveData<String>
        get() = _bossEmployeeName

    private val _bossEmployeePosition = MutableLiveData<String>()
    val bossEmployeePosition: LiveData<String>
        get() = _bossEmployeePosition

    private val _bossEmployeeWage = MutableLiveData<Long>()
    val bossEmployeeWage: LiveData<Long>
        get() = _bossEmployeeWage

    private val _employees = MutableLiveData<List<EmployeeBind>>()
    val employees: LiveData<List<EmployeeBind>>
        get() = _employees

    private val _employeesNew = MutableLiveData<Boolean>()
    val employeesNew: LiveData<Boolean>
        get() = _employeesNew

    override fun setInformationBossEmployee(bossEmployeeBind: BossEmployeeBind) {
        bossEmployeeBind.apply {
            setBossName(name)
            setBossPosition(position)
            setBossWage(wage)
            setListEmployees(employee)
        }
    }

    override fun setBossName(name: String) {
        _bossEmployeeName.value = name
    }

    override fun setBossWage(wage: Long) {
        _bossEmployeeWage.value = wage
    }

    override fun setBossPosition(position: String) {
        _bossEmployeePosition.value = position
    }

    override fun setListEmployees(listEmployees: List<EmployeeBind>) {
        _employees.value = listEmployees
    }

    override fun getEmployeeNewById(idEmployee: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getEmployeeNewById(idEmployee)?.let {
                _employeesNew.postValue(true)
            } ?: run {
                _employeesNew.postValue(false)
            }
        }
    }


}