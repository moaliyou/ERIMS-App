package com.example.erims_app.domain.usecase

import com.example.erims_app.data.mapper.toEmployee
import com.example.erims_app.domain.model.Employee
import com.example.erims_app.domain.repository.EmployeesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetEmployeesUseCase(
    private val employeesRepository: EmployeesRepository
) {
    operator fun invoke(): Flow<List<Employee>> =
        employeesRepository.getAllEmployeesStream().map {
            it.map { employeeEntity ->
                employeeEntity.toEmployee()
            }
        }
}