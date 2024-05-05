package com.example.erims_app.data.mapper

import com.example.erims_app.data.local.entity.EmployeeEntity
import com.example.erims_app.domain.model.Employee
import com.example.erims_app.ui.screens.employee.entry.EmployeeUiState

fun EmployeeEntity.toEmployeeEntity(): Employee = Employee(
    id = id,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
    jobTitle = jobTitle,
    salary = salary.toString()
)

fun Employee.toEmployeeEntity(): EmployeeEntity = EmployeeEntity(
    id = id,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
    jobTitle = jobTitle,
    salary = salary.toDoubleOrNull() ?: 0.0
)

fun EmployeeEntity.toEmployeeUiState(isEntryValid: Boolean = false): EmployeeUiState = EmployeeUiState(
    employee = this.toEmployeeEntity(),
    isEntryValid = isEntryValid
)