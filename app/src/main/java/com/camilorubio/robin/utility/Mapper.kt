package com.camilorubio.robin.utility

import com.camilorubio.robin.domain.dto.BossEmployeeResDTO
import com.camilorubio.robin.domain.dto.CompanyResDTO
import com.camilorubio.robin.domain.dto.EmployeeResDTO
import com.camilorubio.robin.domain.entity.EmployeeNewDB
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind
import com.camilorubio.robin.view.model.EmployeeBind
import com.camilorubio.robin.view.model.EmployeeNewBind

class Mapper {

    companion object {

        inline fun mapCompanyDto(companyResDTO : CompanyResDTO, listBossEmployee : (List<BossEmployeeResDTO>) -> List<BossEmployeeBind>): CompanyBind {
            return CompanyBind(
                companyResDTO.companyName,
                companyResDTO.address,
                listBossEmployee(companyResDTO.employees)
            )
        }

        inline fun mapBossEmployeeDto(listBossEmployee : List<BossEmployeeResDTO>, listEmployee : (List<EmployeeResDTO>) -> List<EmployeeBind>): List<BossEmployeeBind> {
            val listBossEmployeeBind = arrayListOf<BossEmployeeBind>()
            listBossEmployee.forEach { bossEmployeeResDTO ->
                listBossEmployeeBind.add(
                    BossEmployeeBind(
                        id = bossEmployeeResDTO.id,
                        name = bossEmployeeResDTO.name,
                        position = bossEmployeeResDTO.position,
                        wage = bossEmployeeResDTO.wage,
                        employee = listEmployee(bossEmployeeResDTO.employees)
                    )
                )
            }
            return listBossEmployeeBind
        }

        fun mapEmployeeDto(listEmployee : List<EmployeeResDTO>): List<EmployeeBind> {
            val listEmployeeBind = arrayListOf<EmployeeBind>()
            listEmployee.forEach { employeeResDTO ->
                listEmployeeBind.add(
                    EmployeeBind(
                        id = employeeResDTO.id,
                        name = employeeResDTO.name
                    )
                )
            }
            return listEmployeeBind
        }

        fun mapEmployeeDB(listEmployeeNewDB : List<EmployeeNewDB>): List<EmployeeNewBind> {
            val listEmployeeNewBind = arrayListOf<EmployeeNewBind>()
            listEmployeeNewDB.forEach { employeeResDTO ->
                listEmployeeNewBind.add(
                    EmployeeNewBind(
                        id = employeeResDTO.id,
                        name = employeeResDTO.name
                    )
                )
            }
            return listEmployeeNewBind
        }

    }

}

