package com.camilorubio.robin.utils

import com.camilorubio.robin.domain.entity.BossEmployeeResDTO
import com.camilorubio.robin.domain.entity.CompanyResDTO
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.view.model.CompanyBind

class Mapper {

    companion object {

        inline fun mapCompanyDto(companyResDTO : CompanyResDTO, listBossEmployee : (List<BossEmployeeResDTO>) -> List<BossEmployeeBind>): CompanyBind {
            return CompanyBind(
                companyResDTO.companyName,
                companyResDTO.address,
                listBossEmployee(companyResDTO.employees)
            )
        }

        fun mapBossEmployeeDto(listBossEmployee : List<BossEmployeeResDTO>): List<BossEmployeeBind> {
            val listBossEmployeeBind = arrayListOf<BossEmployeeBind>()
            listBossEmployee.forEach { bossEmployeeResDTO ->
                listBossEmployeeBind.add(
                    BossEmployeeBind(
                        id = bossEmployeeResDTO.id,
                        name = bossEmployeeResDTO.name,
                        position = bossEmployeeResDTO.position,
                        wage = bossEmployeeResDTO.wage
                    )
                )
            }
            return listBossEmployeeBind
        }

    }

}

