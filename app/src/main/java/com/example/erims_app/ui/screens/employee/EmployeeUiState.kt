package com.example.erims_app.ui.screens.employee

import com.example.erims_app.data.local.entities.Employee
import java.text.NumberFormat

data class EmployeeUiState(
    val employeeDetails: EmployeeDetails = EmployeeDetails(),
    val isEntryValid: Boolean = false
)

data class EmployeeDetails(
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val jobTitle: String = "",
    val salary: String = "",
)