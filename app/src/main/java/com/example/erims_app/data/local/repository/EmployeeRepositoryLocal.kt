package com.example.erims_app.data.local.repository

import com.example.erims_app.data.local.dao.EmployeeDao
import com.example.erims_app.data.local.entities.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    fun getAllEmployeesStream(): Flow<List<Employee>>
    fun getEmployeeStream(id: Int): Flow<Employee?>
    suspend fun insertEmployee(employee: Employee)
    suspend fun deleteEmployee(employee: Employee)
    suspend fun updateEmployee(employee: Employee)
}

class EmployeeRepositoryLocal(
    private val employeeDao: EmployeeDao
): EmployeeRepository {
    override fun getAllEmployeesStream(): Flow<List<Employee>> = employeeDao.getAllEmployees()

    override fun getEmployeeStream(id: Int): Flow<Employee?> = employeeDao.getEmployee(id)

    override suspend fun insertEmployee(employee: Employee) = employeeDao.insert(employee)

    override suspend fun deleteEmployee(employee: Employee) = employeeDao.delete(employee)

    override suspend fun updateEmployee(employee: Employee) = employeeDao.update(employee)
}