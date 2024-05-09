package com.example.erims_app.domain.usecase

import com.example.erims_app.data.mapper.toEntityEmployee
import com.example.erims_app.domain.model.Employee
import com.example.erims_app.domain.repository.EmployeesRepository

class AddEmployeeUseCase(
    private val employeesRepository: EmployeesRepository,
    private val employeeInputValidatorUseCase: EmployeeInputValidatorUseCase = EmployeeInputValidatorUseCase()
) {
    suspend operator fun invoke(employee: Employee) {
        if (employeeInputValidatorUseCase(employee)) {
            employeesRepository.insertEmployee(employee.toEntityEmployee())
        }
    }
}