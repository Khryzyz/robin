package com.camilorubio.robin.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.camilorubio.robin.domain.entity.EmployeeNewDB

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployeeNew(employeeNewDB: EmployeeNewDB)

    @Query("SELECT * FROM new_employee WHERE id=:idEmployee")
    suspend fun getEmployeeNewById(idEmployee : Long) : EmployeeNewDB?

    @Query("SELECT * FROM new_employee")
    suspend fun getEmployeesNew() : List<EmployeeNewDB>?

}