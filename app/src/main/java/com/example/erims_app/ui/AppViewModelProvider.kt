package com.example.erims_app.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.erims_app.di.DefaultApplication
import com.example.erims_app.ui.screens.employee.EmployeeDetailsViewModel
import com.example.erims_app.ui.screens.employee.EmployeeEntryViewModel
import com.example.erims_app.ui.screens.main.MainViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            EmployeeEntryViewModel(defaultApplication().container.employeesRepository)
        }
        initializer {
            MainViewModel()
        }
        initializer {
            EmployeeDetailsViewModel(defaultApplication().container.employeesRepository)
        }
    }
}

fun CreationExtras.defaultApplication(): DefaultApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as DefaultApplication)