package com.camilorubio.robin.view.model

data class CompanyBind (
    val companyName : String,
    val address : String,
    val employees : List<BossEmployeeBind>
)