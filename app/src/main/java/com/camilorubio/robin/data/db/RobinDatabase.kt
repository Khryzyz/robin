package com.camilorubio.robin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.camilorubio.robin.data.db.dao.EmployeeDao
import com.camilorubio.robin.domain.entity.EmployeeNewDB

@Database(
    entities = [
        EmployeeNewDB::class
    ],
    version = 1
)
abstract class RobinDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

}