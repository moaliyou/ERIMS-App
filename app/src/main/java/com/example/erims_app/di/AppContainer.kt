package com.example.erims_app.di

import android.content.Context
import com.example.erims_app.data.local.ERIMSDatabase
import com.example.erims_app.data.local.repository.EmployeesRepository
import com.example.erims_app.data.local.repository.OfflineEmployeesRepository

interface AppContainer {
    val employeesRepository: EmployeesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val employeesRepository: EmployeesRepository by lazy {
        OfflineEmployeesRepository(ERIMSDatabase.getDatabase(context).employeeDao())
    }
}