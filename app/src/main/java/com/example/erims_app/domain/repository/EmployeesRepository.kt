package com.example.erims_app.domain.repository

import com.example.erims_app.data.local.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow

interface EmployeesRepository {
    fun getAllEmployeesStream(): Flow<List<EmployeeEntity>>
    fun getEmployeeStream(id: Int): Flow<EmployeeEntity?>
    suspend fun insertEmployee(employee: EmployeeEntity)
    suspend fun deleteEmployee(employee: EmployeeEntity)
    suspend fun updateEmployee(employee: EmployeeEntity)
}