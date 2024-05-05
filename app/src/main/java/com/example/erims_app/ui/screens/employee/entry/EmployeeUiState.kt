package com.example.erims_app.ui.screens.employee.entry

import com.example.erims_app.domain.model.Employee

data class EmployeeUiState(
    val employee: Employee = Employee(),
    val isEntryValid: Boolean = false
)