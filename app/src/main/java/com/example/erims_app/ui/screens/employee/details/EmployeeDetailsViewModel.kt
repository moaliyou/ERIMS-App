package com.example.erims_app.ui.screens.employee.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.erims_app.domain.usecase.EmployeeUseCases
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class EmployeeDetailsViewModel (
    employeeUseCases: EmployeeUseCases
): ViewModel() {

    val employeeDetailsUiState: StateFlow<EmployeeDetailsUiState> =
        employeeUseCases.getEmployees().map { EmployeeDetailsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = EmployeeDetailsUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}