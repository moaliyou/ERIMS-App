package com.example.erims_app.data.local.repository

import com.example.erims_app.data.local.entities.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeesRepository {
    fun getAllEmployeesStream(): Flow<List<Employee>>
    fun getEmployeeStream(id: Int): Flow<Employee?>
    suspend fun insertEmployee(employee: Employee)
    suspend fun deleteEmployee(employee: Employee)
    suspend fun updateEmployee(employee: Employee)
}