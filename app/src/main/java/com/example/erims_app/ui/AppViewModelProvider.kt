package com.example.erims_app.ui

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.erims_app.di.DefaultApplication
import com.example.erims_app.ui.screens.employee.EmployeeEntryViewModel
import com.example.erims_app.ui.screens.main.MainViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            EmployeeEntryViewModel(DefaultApplication().container.employeeRepository)
        }
        initializer {
            MainViewModel()
        }
    }
}