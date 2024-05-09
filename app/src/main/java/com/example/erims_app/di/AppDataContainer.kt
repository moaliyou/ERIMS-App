package com.example.erims_app.di

import android.content.Context
import com.example.erims_app.data.local.ERIMSDatabase
import com.example.erims_app.data.repository.EmployeesLocalRepository
import com.example.erims_app.domain.repository.EmployeesRepository
import com.example.erims_app.domain.usecase.AddEmployeeUseCase
import com.example.erims_app.domain.usecase.EmployeeInputValidatorUseCase
import com.example.erims_app.domain.usecase.EmployeeUseCases
import com.example.erims_app.domain.usecase.GetEmployeesUseCase

class AppDataContainer(private val context: Context) : AppContainer {
    override val employeesRepository: EmployeesRepository by lazy {
        EmployeesLocalRepository(ERIMSDatabase.getDatabase(context).employeeDao())
    }
    override val employeeUseCases: EmployeeUseCases by lazy {
        EmployeeUseCases(
            addEmployee = AddEmployeeUseCase(employeesRepository),
            employeeInputValidator = EmployeeInputValidatorUseCase(),
            getEmployees = GetEmployeesUseCase(employeesRepository)
        )
    }
}