package com.example.erims_app.ui.screens.employee

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.erims_app.data.local.entities.Employee
import com.example.erims_app.data.local.repository.EmployeeRepository
import java.text.NumberFormat

class EmployeeEntryViewModel(
    private val employeeRepository: EmployeeRepository
) : ViewModel() {
    var employeeUiState by mutableStateOf(EmployeeUiState())
        private set

    fun updateUiState(employeeDetails: EmployeeDetails) {
        employeeUiState = EmployeeUiState(
            employeeDetails = employeeDetails,
            isEntryValid = validateInput(employeeDetails)
        )
    }

    suspend fun saveEmployee() {
        if (validateInput()) {
            employeeRepository.insertEmployee(employeeUiState.employeeDetails.toEmployee())
        }
    }

    private fun validateInput(uiState: EmployeeDetails = employeeUiState.employeeDetails): Boolean {
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