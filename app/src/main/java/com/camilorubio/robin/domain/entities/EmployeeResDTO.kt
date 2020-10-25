package com.camilorubio.robin.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmployeeResDTO (
    @Json(name = "id") val id : Long,
    @Json(name = "name") val name : String
)