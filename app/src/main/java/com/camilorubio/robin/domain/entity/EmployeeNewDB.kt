package com.camilorubio.robin.domain.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "new_employee")
data class EmployeeNewDB(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val name: String
) : Parcelable