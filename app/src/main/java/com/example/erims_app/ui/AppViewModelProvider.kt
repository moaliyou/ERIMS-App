package com.example.erims_app.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.erims_app.di.DefaultApplication
import com.example.erims_app.ui.screens.employee.details.EmployeeDetailsViewModel
import com.example.erims_app.ui.screens.employee.entry.EmployeeEntryViewModel
import com.example.erims_app.ui.screens.main.MainViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            EmployeeEntryViewModel(defaultApplication().container.employeeUseCases)
        }
        initializer {
            MainViewModel()
        }
        initializer {
            EmployeeDetailsViewModel(defaultApplication().container.employeeUseCases)
        }
    }
}

fun CreationExtras.defaultApplication(): DefaultApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as DefaultApplication)