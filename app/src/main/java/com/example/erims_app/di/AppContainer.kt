package com.example.erims_app.di

import android.content.Context
import com.example.erims_app.data.local.ERIMSDatabase
import com.example.erims_app.domain.repository.EmployeesRepository
import com.example.erims_app.data.repository.EmployeesLocalRepository
import com.example.erims_app.domain.usecase.EmployeeUseCases

interface AppContainer {
    val employeesRepository: EmployeesRepository
    val employeeUseCases: EmployeeUseCases
}