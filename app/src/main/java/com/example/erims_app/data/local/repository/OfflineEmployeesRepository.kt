package com.example.erims_app.data.local.repository

import com.example.erims_app.data.local.dao.EmployeeDao
import com.example.erims_app.data.local.entities.Employee
import kotlinx.coroutines.flow.Flow


class OfflineEmployeesRepository(
    private val employeeDao: EmployeeDao
): EmployeesRepository {
    override fun getAllEmployeesStream(): Flow<List<Employee>> = employeeDao.getAllEmployees()

    override fun getEmployeeStream(id: Int): Flow<Employee?> = employeeDao.getEmployee(id)

    override suspend fun insertEmployee(employee: Employee) = employeeDao.insert(employee)

    override suspend fun deleteEmployee(employee: Employee) = employeeDao.delete(employee)

    override suspend fun updateEmployee(employee: Employee) = employeeDao.update(employee)
}