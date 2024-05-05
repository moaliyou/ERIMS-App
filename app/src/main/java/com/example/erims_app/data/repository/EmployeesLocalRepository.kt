package com.example.erims_app.data.repository

import com.example.erims_app.data.local.dao.EmployeeDao
import com.example.erims_app.data.local.entity.EmployeeEntity
import com.example.erims_app.domain.repository.EmployeesRepository
import kotlinx.coroutines.flow.Flow


class EmployeesLocalRepository(
    private val employeeDao: EmployeeDao
): EmployeesRepository {
    override fun getAllEmployeesStream(): Flow<List<EmployeeEntity>> = employeeDao.getAllEmployees()

    override fun getEmployeeStream(id: Int): Flow<EmployeeEntity?> = employeeDao.getEmployee(id)

    override suspend fun insertEmployee(employee: EmployeeEntity) = employeeDao.insert(employee)

    override suspend fun deleteEmployee(employee: EmployeeEntity) = employeeDao.delete(employee)

    override suspend fun updateEmployee(employee: EmployeeEntity) = employeeDao.update(employee)
}