package com.example.erims_app.ui

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.erims_app.ui.screens.employee.EmployeeEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            EmployeeEntryViewModel()
        }
    }
}