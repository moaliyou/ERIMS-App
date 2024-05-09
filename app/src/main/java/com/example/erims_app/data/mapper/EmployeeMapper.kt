package com.example.erims_app.data.mapper

import com.example.erims_app.data.local.entity.EmployeeEntity
import com.example.erims_app.domain.model.Employee
import java.text.NumberFormat

fun EmployeeEntity.toEmployee(): Employee = Employee(
    id = id,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
    jobTitle = jobTitle,
    salary = salary.toString()
)

fun Employee.toEntityEmployee(): EmployeeEntity = EmployeeEntity(
    id = id,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
    jobTitle = jobTitle,
    salary = salary.toDoubleOrNull() ?: 0.0
)

fun Employee.formattedSalary(): String = NumberFormat
        .getCurrencyInstance()
        .format(salary.toDoubleOrNull())