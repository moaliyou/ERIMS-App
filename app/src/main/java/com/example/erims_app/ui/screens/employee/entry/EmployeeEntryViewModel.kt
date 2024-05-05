package com.example.erims_app.ui.screens.employee.entry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.erims_app.data.local.entity.EmployeeEntity
import com.example.erims_app.domain.model.Employee
import com.example.erims_app.domain.usecase.EmployeeUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.NumberFormat

class EmployeeEntryViewModel(
    private val employeeUseCases: EmployeeUseCases
) : ViewModel() {
    private val _uiState = MutableStateFlow(EmployeeUiState())
    val employeeUiState = _uiState.asStateFlow()

    fun updateUiState(employee: Employee) {
        _uiState.update { currentState ->
            currentState.copy(
                employee = employee,
                isEntryValid = employeeUseCases.employeeInputValidator(employee)
            )
        }
    }

    fun saveEmployee() {
        viewModelScope.launch {
            employeeUseCases.addEmployee(_uiState.value.employee)
        }
    }

}

fun EmployeeEntity.formattedSalary(): String = NumberFormat.getCurrencyInstance().format(salary)