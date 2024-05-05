package com.example.erims_app.domain.usecase

data class EmployeeUseCases(
    val addEmployee: AddEmployeeUseCase,
    val employeeInputValidator: EmployeeInputValidatorUseCase
)