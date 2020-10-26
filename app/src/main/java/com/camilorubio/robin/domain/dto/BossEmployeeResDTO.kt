package com.camilorubio.robin.domain.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BossEmployeeResDTO (
    @Json(name = "id") val id : Long,
    @Json(name = "name") val name : String,
    @Json(name = "position") val position : String,
    @Json(name = "wage") val wage : Long,
    @Json(name = "employees") val employees : List<EmployeeResDTO>
)