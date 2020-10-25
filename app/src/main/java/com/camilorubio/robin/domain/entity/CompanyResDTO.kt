package com.camilorubio.robin.domain.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyResDTO (
    @Json(name = "company_name") val companyName : String,
    @Json(name = "address") val address : String,
    @Json(name = "employees") val employees : List<BossEmployeeResDTO>
)