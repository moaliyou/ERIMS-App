package com.example.erims_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.erims_app.data.local.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: EmployeeEntity)

    @Update
    suspend fun update(employee: EmployeeEntity)

    @Delete
    suspend fun delete(employee: EmployeeEntity)

    @Query("SELECT * FROM employees WHERE id = :id")
    fun getEmployee(id: Int): Flow<EmployeeEntity>

    @Query("SELECT * FROM employees ORDER BY firstName ASC")
    fun getAllEmployees(): Flow<List<EmployeeEntity>>
}