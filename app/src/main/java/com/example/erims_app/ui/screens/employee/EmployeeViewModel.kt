package com.example.erims_app.ui.screens.employee

import androidx.lifecycle.ViewModel
import com.example.erims_app.data.local.entities.Employee
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class EmployeeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<EmployeeUiState>(EmployeeUiState())
    val employeeUiState: StateFlow<EmployeeUiState> = _uiState.asStateFlow()

    fun updateUiState(employeeDetails: EmployeeDetails) {
        _uiState.update { currentState ->
            currentState.copy(
                employeeDetails = employeeDetails,
                isEntryValid = validateInput(currentState.employeeDetails)
            )
        }
    }

    private fun validateInput(uiState: EmployeeDetails = employeeUiState.value.employeeDetails): Boolean {
        return with(uiState) {
            firstName.isNotBlank() && lastName.isNotBlank()
                    && dateOfBirth.isNotBlank() && jobTitle.isNotBlank() && salary.isNotBlank()
        }
    }

}

fun EmployeeDetails.toEmployee(): Employee = Employee(
    id = id,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
    jobTitle = jobTitle,
    salary = salary.toDoubleOrNull() ?: 0.0
)

fun Employee.formattedSalary(): String = NumberFormat.getCurrencyInstance().format(salary)

fun Employee.toEmployeeDetails(): EmployeeDetails = EmployeeDetails(
    id = id,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
    jobTitle = jobTitle,
    salary = salary.toString()
)

fun Employee.toEmployeeUiState(isEntryValid: Boolean = false): EmployeeUiState = EmployeeUiState(
    employeeDetails = this.toEmployeeDetails(),
    isEntryValid = isEntryValid
)