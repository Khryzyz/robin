package com.camilorubio.robin.domain.usecase

import com.camilorubio.robin.data.ResponseState
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.viewmodel.home.IContractHome
import java.util.*
import javax.inject.Inject

class HomeUseCases @Inject constructor(private val repository: IContractHome.Repository) : IContractHome.UseCases {

    override suspend fun getEmployees(responseState : (ResponseState) -> Unit) {
        repository.getEmployees {
            responseState(it)
        }
    }

    override fun setItemsSelectable(status : Boolean, listBossEmployeeBind: List<BossEmployeeBind>): List<BossEmployeeBind> {
        val newList = arrayListOf<BossEmployeeBind>()
        listBossEmployeeBind.forEach { bossEmployeeBind ->
            newList.add(
                BossEmployeeBind(
                    id = bossEmployeeBind.id,
                    name = bossEmployeeBind.name,
                    position = bossEmployeeBind.position,
                    wage = bossEmployeeBind.wage,
                    employee = bossEmployeeBind.employee,
                    isSelectable = status
                )
            )
        }
        return newList
    }

    override fun cleanSelection(listBossEmployeeBind: List<BossEmployeeBind>): List<BossEmployeeBind> {
        val newList = arrayListOf<BossEmployeeBind>()
        listBossEmployeeBind.forEach { bossEmployeeBind ->
            newList.add(
                BossEmployeeBind(
                    id = bossEmployeeBind.id,
                    name = bossEmployeeBind.name,
                    position = bossEmployeeBind.position,
                    wage = bossEmployeeBind.wage,
                    employee = bossEmployeeBind.employee,
                    isSelectable = false
                )
            )
        }
        return newList
    }

    override fun setStatusCheckByEmployee(
        idEmployee: Long,
        status: Boolean,
        listBossEmployeeBind: List<BossEmployeeBind>
    ): List<BossEmployeeBind> {
        val newList = arrayListOf<BossEmployeeBind>()
        listBossEmployeeBind.forEach { bossEmployeeBind ->
            newList.add(
                BossEmployeeBind(
                    id = bossEmployeeBind.id,
                    name = bossEmployeeBind.name,
                    position = bossEmployeeBind.position,
                    wage = bossEmployeeBind.wage,
                    employee = bossEmployeeBind.employee,
                    isSelectable = bossEmployeeBind.isSelectable,
                    isSelected = if (idEmployee == bossEmployeeBind.id) status else bossEmployeeBind.isSelected
                )
            )
        }
        return newList
    }

    override suspend fun saveEmployeesAsNew(listBossEmployeeBind: List<BossEmployeeBind>) {
        listBossEmployeeBind.filter { bossEmployeeBind ->
            bossEmployeeBind.isSelected
        }.let { listFiltrated ->
            listFiltrated.forEach { bossEmployeeFiltrated ->
                repository.saveEmployeesAsNew(
                    EmployeeNewDB(
                        id = bossEmployeeFiltrated.id,
                        name = bossEmployeeFiltrated.name
                    )
                )
            }
        }
    }

    override fun filterListEmployees(newText: String, listBossEmployeeBind: List<BossEmployeeBind>): List<BossEmployeeBind>? {
        return listBossEmployeeBind.filter { bossEmployeeBind ->
            bossEmployeeBind.name.trim().toLowerCase(Locale.ROOT).contains(
                newText.trim().toLowerCase(
                    Locale.ROOT
                )
            )
        }
    }

    override fun sortList(listBossEmployeeBind: List<BossEmployeeBind>): List<BossEmployeeBind>? {
        return if (listBossEmployeeBind[0].wage < listBossEmployeeBind.last().wage) {
            listBossEmployeeBind.sortedByDescending { bossEmployeeBind ->
                bossEmployeeBind.wage
            }
        } else {
            listBossEmployeeBind.sortedBy { bossEmployeeBind ->
                bossEmployeeBind.wage
            }
        }
    }

}