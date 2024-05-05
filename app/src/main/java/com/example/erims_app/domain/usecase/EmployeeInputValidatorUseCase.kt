package com.example.erims_app.domain.usecase

import com.example.erims_app.domain.model.Employee

class EmployeeInputValidatorUseCase {
    operator fun invoke(employeeDataInput: Employee): Boolean {
        return with(employeeDataInput) {
            firstName.isNotBlank() && lastName.isNotBlank()
                    && dateOfBirth.isNotBlank()
                    && jobTitle.isNotBlank() && salary.isNotBlank()
        }
    }
}