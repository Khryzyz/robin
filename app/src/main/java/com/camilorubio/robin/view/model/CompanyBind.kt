package com.camilorubio.robin.view.model

data class CompanyBind (
    val companyName : String,
    val address : String,
    var employees : List<BossEmployeeBind>
)