package com.example.erims_app.di

import android.content.Context
import com.example.erims_app.data.local.ERIMSDatabase
import com.example.erims_app.data.local.repository.EmployeeRepository
import com.example.erims_app.data.local.repository.EmployeeRepositoryLocal

interface AppContainer {
    val employeeRepository: EmployeeRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val employeeRepository: EmployeeRepository by lazy {
        EmployeeRepositoryLocal(ERIMSDatabase.getDatabase(context).employeeDao())
    }
}